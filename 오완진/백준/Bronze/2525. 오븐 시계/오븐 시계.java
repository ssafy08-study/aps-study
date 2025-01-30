import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int hr = sc.nextInt();
		int min = sc.nextInt();
		int cook = sc.nextInt();
		
		sc.close();
		
		hr += cook / 60;
		min += cook % 60;
		
		if ( min >= 60) {
			hr += 1;
			min -= 60;
		}
		
		if ( hr >= 24 ) {
			hr -= 24;
		}

		System.out.println(hr + " " + min);
		
	}

}
