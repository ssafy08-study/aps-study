import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] intArr = new int[N];
		int[] orderedArr = new int[N];
		
		for (int i = 0; i < N; i++)
			intArr[i] = sc.nextInt();
		
		for (int i = 0; i < N; i++) {

			int max = 0;
			int idx = 0;
			
			for (int j = 0; j < N; j++) {
				if (intArr[j] > max) {
					max = intArr[j];
					idx = j;
				}
			}
			
			orderedArr[i] = max;
			intArr[idx] = 0;
			
		}

//		for (int num : orderedArr)
//			System.out.print(num + " ");
		
		System.out.println(orderedArr[(N/2)]);
		
	}
}
