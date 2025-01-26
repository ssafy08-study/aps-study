
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	static int[] p;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			p = new int[V+1];
			
			for(int i=1 ; i<=V ; i++) {
				p[i] = i;
			}
			
			for(int i=0 ; i<E ; i++) {
				
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				p[findSet(A)] = findSet(B);	
				// A와 B의 최고 조상의 크기를 비교하여 연결 규칙을 정할 수 있지만
				// 이 문제에서는 무리의 개수를 구하면 되기 때문에 필요 없다
				
			}
			
			for(int i=1 ; i<=V ; i++) {	// 갱신이 안 된 자식? 이 있을 수 있으므로 갱신 해줘야 한다 => 갱신 하지 않아도 자신의 대표가 자기 자신인 개수 세면 된다.
				p[findSet(i)] = findSet(i);
			}
			
			
			Set<Integer> cnt = new HashSet<>();	// Set을 쓸 수 도 있고, boolean 배열을 만들어서 확인 할 수 도 있다
			
			for(int i=1 ; i<=V ; i++) {
				cnt.add(p[i]);
			}
			
			int answer = cnt.size();
			
			System.out.println("#"+tc+" "+answer);
			
		}
		
		
		
	}

	private static int findSet(int a) {
		if(a != p[a]) {
			p[a] = findSet(p[a]);
		}
		return p[a];
	}

}
