import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			
			// 델타배열 : 우(0) 하(1) 좌(2) 상(3)
			int[] rWay = {0, 1, 0, -1};
			int[] cWay = {1, 0, -1, 0};
			// 방향 설정에 사용
			int way = 0;
			// 좌표 설정에 사용
			int rNext = 0;
			int cNext = 0;
			// 입력할 숫자
			int ggomul = 1;
			
			for (int n = 0; n < N*N; n++) {
				
				int rNow = rNext;
				int cNow = cNext;
				
				snail[rNow][cNow] = ggomul++;
				
				rNext = rNow + rWay[way];
				cNext = cNow + cWay[way];

				// 방향 설정 : 1. 우-하-좌-상   2. 영역 제한   3. 0이 아닌 다른 숫자 조우
				// Short Circuit 사용
				if (rNext >= 0 && rNext < N && cNext >= 0 && cNext < N && snail[rNext][cNext] == 0) {
					continue;
				} else {
					way = (way + 1) % 4;
					rNext = rNow + rWay[way];
					cNext = cNow + cWay[way];
				}
					
			}
			
			System.out.println("#" + t);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					System.out.print(snail[r][c] + " ");
				}
				System.out.println();

			}
		}
		
	}
}