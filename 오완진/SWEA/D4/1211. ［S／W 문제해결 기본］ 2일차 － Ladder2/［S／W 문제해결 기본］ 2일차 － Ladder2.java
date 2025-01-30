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
			
			// start 찾기 ~ end 찾기 ~ 이동거리 측정
			int shortCut = 9999;
			int shortIdx = 9999;
			int start = 0;
			for (int c = 0; c < 100; c++) {
				int cnt = 0;
				start = c;
				if (sadari[0][c] != 1) continue;
				
				int rNow = 0;
				int cNow = start;
				
				while (rNow < 99) {
					if (cNow > 0 && sadari[rNow][cNow - 1] == 1) {
						while (cNow > 0 && sadari[rNow][cNow -1] == 1) {
							cNow--;
							cnt++;
						}
					} else if (cNow < 99 && sadari[rNow][cNow + 1] == 1) {
						while (cNow < 99 && sadari[rNow][cNow + 1] == 1) {
							cNow++;
							cnt++;
						}
					}
					rNow++;
					cnt++;
				}
				
				if (cnt < shortCut) {
					shortCut = cnt;
					shortIdx = start;
				}
				
			}
			System.out.println("#" + T + " " + shortIdx);
			
		}
		
	}
}