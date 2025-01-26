import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(count(n));
        }
    }

    public static int count(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        // 1만 사용
        for (int i = 1; i <= n; i++) {
            dp[i] += dp[i - 1];
        }

        // 2만 사용
        for (int i = 2; i <= n; i++) {
            dp[i] += dp[i - 2];
        }

        // 3만 사용
        for (int i = 3; i <= n; i++) {
            dp[i] += dp[i - 3];
        }

        return dp[n];
    }
}