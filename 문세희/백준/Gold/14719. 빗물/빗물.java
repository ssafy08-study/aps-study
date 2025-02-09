import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[] blocks = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = 0;
        
        // 각 위치별로 빗물의 양 계산
        for (int i = 1; i < W - 1; i++) {
            int leftMax = blocks[i];
            int rightMax = blocks[i];
            
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, blocks[j]);
            }
            
            for (int j = i + 1; j < W; j++) {
                rightMax = Math.max(rightMax, blocks[j]);
            }
            
            int minHeight = Math.min(leftMax, rightMax);
            if (minHeight > blocks[i]) {
                result += minHeight - blocks[i];
            }
        }
        
        System.out.println(result);
    }
}