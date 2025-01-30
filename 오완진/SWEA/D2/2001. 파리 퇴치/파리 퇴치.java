import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] pari = new int[N][N];
			int max = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					pari[r][c] = sc.nextInt();
				}
			}
			
			// 파리채가 영역을 벗어나지 않도록 N-M+1
			for (int r = 0; r < N-M+1; r++) {
				for (int c = 0; c < N-M+1; c++) {
					int[][] choi = new int[M][M];
					int kill = 0;
					
					for (int rr = 0; rr < M; rr++) {
						for (int cc = 0; cc < M; cc++) {
							choi[rr][cc] = pari[r+rr][c+cc];
							kill += choi[rr][cc];
						}
					}
					max = Math.max(max, kill);
					
				}
			}
			
			System.out.println("#" + t + " " + max);
			
		}
		
	}
}