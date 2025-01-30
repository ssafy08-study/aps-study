import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[9];
		int max = 0;
		int cnt = 0;
		
		for (int i = 0; i < 9; i++) {
			num[i] = sc.nextInt();
		}
		
		for (int j = 0; j < 9; j++) {
			if (num[j] > max) {
				max = num[j];
				cnt = j+1;
			}
		}
		
		System.out.println(max);
		System.out.println(cnt);
	}
}