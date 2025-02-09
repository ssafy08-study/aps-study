import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] result = new int[n];
        
        // 스택을 이용하여 각 탑의 수신 탑 찾기
        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // 현재 탑보다 낮은 탑은 모두 제거
            while (!stack.isEmpty() && stack.peek()[1] < heights[i]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                result[i] = stack.peek()[0] + 1; 
            }
            
            // 현재 탑을 스택에 추가
            stack.push(new int[]{i, heights[i]});
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]);
            if (i < n-1) sb.append(" ");
        }
        System.out.println(sb);
    }
}