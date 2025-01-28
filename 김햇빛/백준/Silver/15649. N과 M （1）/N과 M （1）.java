import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int n, m;
	static ArrayList<Integer> arr;
	static boolean[] selected;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		
		arr = new ArrayList<>();
		selected = new boolean[n+1];
		
		// 1부터 n까지의 자연수 중에서 중복 없이 m개를 고른 수열
		// 순열 
		perm(0);
	}
	
	static void perm(int cnt) {
		// 기저조건
		// m개를 뽑으면 수열 출력하기  
		if (cnt == m) {
			for (int i=0; i<m; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		// 숫자를 뽑을 것인데 
		for (int i=1; i<=n; i++) {
			if (selected[i]) continue;
			// 일단 차례대로 넣기 
			arr.add(i);
			selected[i] = true;
			// 하나 더 뽑기 
			perm(cnt+1);
			// 뽑은 것은 다시 빼주기 
			arr.remove(arr.size()-1);
			selected[i] = false;
		}
	}

}
