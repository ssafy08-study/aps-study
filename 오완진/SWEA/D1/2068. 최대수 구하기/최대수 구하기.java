import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[][] intArr = new int[T][10];
		
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 10; j++) {
				intArr[i][j] = sc.nextInt();
			}
		}
		
		
		for (int i = 0; i < T; i++) {
			
			int max = intArr[i][0];
			
			for (int j = 0; j < 10; j++)
				max = intArr[i][j] > max ? intArr[i][j] : max;
				
			System.out.printf("#%d " + max, i+1);
			System.out.println();
		}
		
	}
}