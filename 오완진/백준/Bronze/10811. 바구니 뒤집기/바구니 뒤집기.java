import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int tmp;
		
		int[] basket = new int[N];
		
		for (int a = 1; a <= N; a++) {
			basket[a-1] = a;
		}
		
		for (int b = 0; b < M; b++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			while (i < j) {
				tmp = basket[i-1];
				basket[i-1] = basket[j-1];
				basket[j-1] = tmp;
				i++;
				j--;
			}
			
		}
		
		for (int e = 0; e < N; e++) {
			System.out.print(basket[e] + " ");
		}
		
	}
}