import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		
		arr = new int[m];
		
		// 1부터 뽑으므로 1
		// 깊이는 0부터 
		recur(1, 0);
	}
	
	static void recur(int idx, int depth) {
		if (depth == m) {
			for (int num: arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		//idx부터 n까지의 수를 순차적으로 뽑음 
		for (int i=idx; i<=n; i++) {
			// 해당깊이(인덱스)에 숫자를 계속 덮어써주기 
			arr[depth] = i;
			// 하나씩 올려가며 뽑고 깊이도 올려줌 
			recur(i+1, depth+1);
		}
	}

}
