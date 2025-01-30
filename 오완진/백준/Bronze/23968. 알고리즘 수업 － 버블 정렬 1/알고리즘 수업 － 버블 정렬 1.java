import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];
				
		for (int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}
		
		int cnt = 0;
		for (int i = arr.length-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
					cnt++;
					
					if (cnt == K) {
						int a = Math.min(arr[j], arr[j+1]);
						int b = Math.max(arr[j], arr[j+1]);
						System.out.println(a + " " + b);
						return;
					}
				}
			}
		}
		
		if (cnt < K)
			System.out.println(-1);
		
	}
}