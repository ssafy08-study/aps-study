import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int one = sc.nextInt();
		int two = sc.nextInt();
		int thr = sc.nextInt();
		int money;
		int max;
		
		sc.close();
		
		if (two == one) {
			if (thr == one) {
				money = 10000 + 1000 * one;
			} else {
				money = 1000 + 100 * one;
			}
		} else if (thr == one) {
			money = 1000 + 100 * thr;
		} else if (two == thr) {
			money = 1000 + 100 * two;
		} else {
			max = one;
			if (two > max) max = two;
			if (thr > max) max = thr;
			money = 100 * max;
		}
		System.out.println(money);
	}
}
