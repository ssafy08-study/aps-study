import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] A = new int[10];
		
		for (int i = 0; i < 10; i++) {
			int x = sc.nextInt();
			A[i] = x;
		}
		
		int[] B = new int[10];
		
		for (int j = 0; j < 10; j++) {
			B[j] = A[j] % 42;
		}
		
		int[] C = new int[42];
		
		for (int k = 0; k < 10; k++) {
			C[B[k]] = 1;
		}
		
		int cnt = 0;
		
		for (int l = 0; l < 42; l++) {
			if (C[l] == 1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}