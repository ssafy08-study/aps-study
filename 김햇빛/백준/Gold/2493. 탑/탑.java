import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] towers = new int[N];
        int[] ans = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스만 저장

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && towers[stack.peek()] <= towers[i]) {
                stack.pop(); // 더 낮은 타워 제거
            }

            ans[i] = stack.isEmpty() ? 0 : stack.peek() + 1; // 1-based index
            stack.push(i); // 현재 타워 인덱스 저장
        }

        for (int num : ans) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
