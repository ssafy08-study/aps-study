import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] bascket = new int[N];
		
		for (int a = 1; a <= N; a++) {
			bascket[a-1] = a;
		}
		
		for (int b = 0; b < M; b++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int tmp = 0;
			
			tmp = bascket[i-1];
			bascket[i-1] = bascket[j-1];
			bascket[j-1] = tmp;
			
		}

		for (int c = 0; c < N; c++) {
			System.out.print(bascket[c] + " ");
		}
	}
}