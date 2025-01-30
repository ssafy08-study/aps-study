import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			
			int T = sc.nextInt();
			int[][] sadari = new int[100][100];
			
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					sadari[r][c] = sc.nextInt();
				}
			}
			
			// end 찾기 ~ 역주행 ~ start 찾기
			int end = -1;
			for (int c = 0; c < 100; c++) {
				if (sadari[99][c] == 2) {
					end = c;
					break;
				}
			}
			
			int rNow = 99;
			int cNow = end;
			
			while (rNow > 0) {
				// 좌 탐색 후 좌 전진
				if (cNow > 0 && sadari[rNow][cNow - 1] == 1) {
					while (cNow > 0 && sadari[rNow][cNow - 1] == 1)
						cNow--;
				// 우 탐색 후 우 전진
				} else if (cNow < 99 && sadari[rNow][cNow + 1] == 1) {
					while (cNow < 99 && sadari[rNow][cNow + 1] == 1)
						cNow++;
				} 
				// 상 전진
				rNow--;
			}
			
			System.out.println("#" + T + " " + cNow);
		}
		
	}
}
