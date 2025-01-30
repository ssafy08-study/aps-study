import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <=10; t++) {
			
			int N = sc.nextInt();
			
			int[] dump = new int[100];
			for (int i = 0; i < 100; i++) {
				dump[i] = sc.nextInt();
			}
			
//			for (int num : dump)
//				System.out.print(num + " ");
//			System.out.println();
			
			for (int n = 0; n < N; n++) {
				
				Arrays.sort(dump);

				if (dump[0] == dump[99]) break;
				dump[0]++;
				dump[99]--;
				
			}
			
			// 최고점&최저점 최신화
			Arrays.sort(dump);
			int result = dump[99] - dump[0];
			System.out.println("#" + t + " " + result);
			
		}
		
	}
}