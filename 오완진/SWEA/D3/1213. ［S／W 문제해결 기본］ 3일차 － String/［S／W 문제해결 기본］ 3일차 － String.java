import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int T = sc.nextInt();
			
			String ptn = sc.next();
			String txt = sc.next();
			
			int pi = 0;		// pattern idx
			int ti = 0;		// text idx
			int cnt = 0;
			
			// 1 2 3 4 5 6 7 8 9
			// ptn 길이 2 -> 89 까지만
			// 9 .. index boundary error
			outer:
			for (ti = 0; ti < txt.length() - ptn.length() + 1; ti++) {
				for (pi = 0; pi < ptn.length(); pi++) {
					if (ptn.charAt(pi) != txt.charAt(ti + pi)) {
						continue outer;
					}
				}
				cnt++;
			}
			
			System.out.println("#" + T + " " + cnt);
		}
		
	}
}