import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int result = 1;
			String word = sc.next();
			char[] wordArr = word.toCharArray();

			int N = wordArr.length;
			char[] drowArr = new char[N];
			
			for (int i = 0; i < N; i++) {
				drowArr[N-1-i] = wordArr[i];
			}
			
			for (int i = 0; i < N; i++) {
				if (wordArr[i] != drowArr[i]) {
					result = 0;
					break;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
		
	}
}