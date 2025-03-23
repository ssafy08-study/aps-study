import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] skyline = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            skyline[i][0] = Integer.parseInt(input[0]);
            skyline[i][1] = Integer.parseInt(input[1]);
        }
        
        int result = getMinBuildings(skyline, n);
        System.out.println(result);
    }
    
    public static int getMinBuildings(int[][] skyline, int n) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int height = skyline[i][1];
            
            // 현재 높이보다 큰 건물들은 모두 제거 (끝난 것으로 간주)
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
            }
            
            // 스택이 비어있거나 맨 위의 높이가 현재 높이와 다르면 새 건물 추가
            if ((stack.isEmpty() || stack.peek() != height) && height > 0) {
                stack.push(height);
                count++;
            }
        }
        
        return count;
    }
}