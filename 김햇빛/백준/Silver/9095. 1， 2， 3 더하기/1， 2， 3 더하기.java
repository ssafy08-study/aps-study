import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int[] nums = new int[] {1, 2, 3};
		for (int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			
			int[] dp = new int[n+1];
			
			dp[0] = 1;
//			4일 땐, 3, 2, 1의 경우를 다 더하면 됨
//			3일 땐, 2, 1, 0
//			2일 땐 1, 0
//			1일 땐 0
			for (int i=1; i<=n; i++) {
				for (int num: nums) {
					if (i-num >= 0) {
						dp[i] += dp[i-num];
					}
				}
			}

			System.out.println(dp[n]);
		}
		
	}
}
