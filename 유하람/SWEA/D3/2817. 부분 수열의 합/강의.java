import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static int N, K;
    static Stack<Integer> stack = new Stack<>();
    static int[] nums;

    static int sum;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();

            nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            sum = 0;
            answer = 0;
            recur(0, -1);

            System.out.println("#" + tc + " " + answer);
        }
    }

    // 한 번 호출할 때마다 원소 하나 선택
    // (level + 1)번째 원소 선택
    static void recur(int level, int lastItem) {
        if (sum == K) {
            answer++;
        }

        // 기저조건
        if (sum >= K || level == N) {
            return;
        }

        // 재귀영역
        for (int i = lastItem + 1; i < N; i++) {
            // i번째 원소 선택
            stack.push(nums[i]);
            sum += nums[i];
            recur(level + 1, i);
            // i번째 원소 빼내기
            stack.pop();
            sum -= nums[i];
        }
    }

}
