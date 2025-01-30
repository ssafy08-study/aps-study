import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			
			int N = sc.nextInt();
			int[] building = new int[N];
			
			for (int j = 0; j < N; j++) {
				building[j] = sc.nextInt();
			}
			
//			for (int num : building)
//				System.out.print(num + " ");
			
			int cnt = 0;
			for (int j = 2; j <= N-3; j++) {
					
					int max = 0;
					max = Math.max(max, building[j-1]);
					max = Math.max(max, building[j+1]);
					max = Math.max(max, building[j-2]);
					max = Math.max(max, building[j+2]);
//					System.out.println(j + ", " + max + ", " + cnt);
					
					if (building[j] > max) {
						int tmp = building[j] - max;
						cnt += tmp;
					}
					
			}

			System.out.printf("#%d " + cnt, i+1);
			System.out.println();
			
		}
		
	}
}