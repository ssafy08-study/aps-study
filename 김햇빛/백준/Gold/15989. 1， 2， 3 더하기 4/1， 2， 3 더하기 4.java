import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] testCases = new int[T];
        int maxN = 0;

        // 테스트 케이스 입력 및 최대 n 계산
        for (int i = 0; i < T; i++) {
            testCases[i] = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, testCases[i]);
        }

        // DP 배열 초기화
        // dp[i][j]: 정수 i를 1~j만 사용해 만드는 경우의 수
        int[][] dp = new int[maxN + 1][4];

        // 아무것도 선택하지 않는 경우
        dp[0][0] = 1; 

        for (int j = 1; j <= 3; j++) {
            for (int i = 0; i <= maxN; i++) {
                dp[i][j] = dp[i][j - 1]; // j-1까지의 경우의 수 가져오기
                if (i >= j) {
                    dp[i][j] += dp[i - j][j]; // j를 포함한 경우 추가
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int n : testCases) {
            sb.append(dp[n][3]).append("\n");
        }
        System.out.print(sb);
    }
}
