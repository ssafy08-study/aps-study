import java.util.Scanner;

public class Solution {
	
	static int N;
	static int M;
	static int num;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int TC = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			num = 1;
			
			zgop(false, 0);
			
			System.out.println("#" + TC + " " + num);
		
		}
		
	}
	
	static void zgop(boolean isComplete, int cnt) {
		if (isComplete) return;
		if (cnt == M - 1) isComplete = true;

		num *= N;
		zgop(isComplete, cnt + 1);
	}
	
}
