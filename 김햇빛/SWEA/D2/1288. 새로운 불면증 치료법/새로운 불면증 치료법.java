import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			
			int cnt = 0; // 횟수 
			int bit = 0; // 비트 마스크 
			
			while(bit != (1<<10) -1) {
				cnt++;
				
				int tmp = cnt * n;
                
                // 각 자릿수 비트마스킹 해주기
				while (tmp > 0) {
					int digit = tmp % 10;
					bit = bit | (1 << digit);
					tmp /= 10;
				}
			}
			
			System.out.println("#" + tc + " " + n * cnt);
		}
		
	}

}
