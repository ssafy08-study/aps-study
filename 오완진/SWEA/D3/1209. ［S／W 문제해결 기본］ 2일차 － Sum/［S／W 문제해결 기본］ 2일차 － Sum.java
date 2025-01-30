import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int T = sc.nextInt();
			
			int[][] square = new int[100][100];
			int max = 0;
			int sum = 0;
			
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					square[r][c] = sc.nextInt();
				}
			}
			
			// 가로
			for (int r = 0; r < 100; r++) {
				sum = 0;
				for (int c = 0; c < 100; c++) {
					sum += square[r][c];
				}
				max = Math.max(max, sum);
			}
			
			// 세로
			for (int c = 0; c < 100; c++) {
				sum = 0;
				for (int r = 0; r < 100; r++) {
					sum += square[r][c];
				}
				max = Math.max(max, sum);
			}
			
			// 대각선1
			sum = 0;
			for (int r = 0; r < 100; r++) {
				sum += square[r][r];
			}
			max = Math.max(max, sum);
			
			// 대각선2
			sum = 0;
			for (int r = 0; r < 100; r++) {
				sum += square[99-r][r];
			}
			max = Math.max(max, sum);
			
			System.out.println("#" + T + " " + max);
		}
		
	}
}
