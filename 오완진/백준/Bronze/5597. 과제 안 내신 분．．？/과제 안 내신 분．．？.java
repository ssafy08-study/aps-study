import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] X = new int[30];
		
		for (int i = 0; i < 28; i++) {
			int N = sc.nextInt();
			X[N-1] = N;
		}
		
		for (int j = 0; j < 30; j++) {
			if (X[j] == 0) {
				System.out.println(j+1 + " ");
			}
		}
	}
}