import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		int i = sc.nextInt();
		
		char ch = S.charAt(i-1);
		
		System.out.println(ch);
		
	}
}