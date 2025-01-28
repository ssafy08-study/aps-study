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
		
		recur(1, 0);
		System.out.println(sb);
	}
	
	static void recur(int idx, int depth) {
		if (depth == m) {
			for (int num: arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 1부터 n까지 뽑는데,
		for (int i=idx; i<=n; i++) {
			arr[depth] = i;
			recur(i, depth+1);
		}
	}

}
