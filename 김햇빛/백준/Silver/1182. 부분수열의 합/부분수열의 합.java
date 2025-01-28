import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int n, s;
	static int cnt = 0;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		s = sc.nextInt();
		
		arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}

		recur(0, 0);
		
		if (s == 0) {
			cnt--;
		}
		System.out.println(cnt);
	}
	
	static void recur(int idx, int sum) {
		if (idx == n) {
			if (sum == s) {
				cnt++;
			}
			return;
		}
		
		recur(idx+1, sum);
		recur(idx+1, sum + arr[idx]);
	}
}
