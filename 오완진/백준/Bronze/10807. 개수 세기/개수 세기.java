import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] num = new int[n];
		
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		
		int v = sc.nextInt();
		int cnt = 0;
		
		for (int j = 0; j < n; j++) {
			if (v == num[j]) cnt++;
		}
		
		System.out.println(cnt);
		
	}
}