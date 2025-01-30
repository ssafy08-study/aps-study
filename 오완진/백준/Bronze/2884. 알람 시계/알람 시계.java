
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int hr = sc.nextInt();
		int min = sc.nextInt();
		
		if (min < 45) {
			if (hr == 0) {
				hr = 23;
			} else {
				hr--;
			}
			min = min + 15;
		} else {
			min = min - 45;
		}
		
		System.out.println(hr + " " + min);
	}
	
}