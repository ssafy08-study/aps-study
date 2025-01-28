import java.util.Arrays;
import java.util.Scanner;


public class Main {
	static int sum = 0;
	static boolean find = false;
	static int[] heights, ans;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner s = new Scanner(System.in);
		
		heights = new int[9];
		ans = new int[7];
		for (int i=0; i<9; i++) {
			heights[i] = s.nextInt();
		}
		
		recur(0, 0);
		
		System.out.println(sb);
	}
	
	static void recur(int idx, int depth) {
		if (find || sum > 100) {
			return;
		}
		
		if (depth == 7) {
			if (!find && sum == 100) {
				Arrays.sort(ans);
				for (int h: ans) {
					System.out.println(h);
				}
				find = true;
			}
			return;
		}
		
		for (int i=idx; i<9; i++) {
			ans[depth] = heights[i];
			sum += heights[i];
			recur(idx+1, depth+1);
			sum -= heights[i];
		}
	}
	

}
