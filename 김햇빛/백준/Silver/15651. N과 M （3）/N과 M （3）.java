import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		
		arr = new int[m];
		
		recur(0);
		System.out.println(sb);
	}
	
	static void recur(int depth) {
		if (depth == m) {
			for (int num: arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 1부터 n까지 뽑는데,
		for (int i=1; i<=n; i++) {
			// 값은 계속 덮어써주고, 
			arr[depth] = i;
			// 하나씩 계속 높여준다.
			recur(depth+1);
		}
	}

}
