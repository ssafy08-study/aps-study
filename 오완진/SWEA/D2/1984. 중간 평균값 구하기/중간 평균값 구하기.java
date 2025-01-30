import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int[] arr = new int[10];
			
			for (int n = 0; n < 10; n++) {
				arr[n] = sc.nextInt();
			}
			
			for (int i = 0; i < 10; i++) {
				
				int minIdx = i;
				for (int j = i+1; j < 10; j++) {
					if (arr[minIdx] > arr[j])
						minIdx = j;
				}
				
				int tmp = arr[i];
				arr[i] = arr[minIdx];
				arr[minIdx] = tmp;
				
			}
			
			int sum = 0;
			double avg = 0.0;
			int result = 0;
			for (int i = 1; i < 9; i++) {
				sum += arr[i];
				avg = (double)sum / 8;
				avg = Math.round(avg);
				result = (int)avg;
			}
			
			System.out.printf("#%d " + result, t);
			System.out.println();
			
		}
		
	}
	
}
