import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 요영식이 이미 가지고 있는 랜선의 개수
		int K = sc.nextInt();
		
		// 필요한 랜선의 개수
		int N = sc.nextInt();
		
		// 가지고 있는 랜선들
		int[] lines = new int[K];
		
		int min = Integer.MAX_VALUE;
		int max = 0;
		
		for(int i=0 ; i<K ; i++) {
			lines[i] = sc.nextInt();
			min = Math.min(min, lines[i]);
			max = Math.max(max, lines[i]);
		}
		
		long answer = 0;
		
		long L = 0;
		long R = max;
		
		while(L<=R) {
			long mid = (L+R)/2;
			if(mid==0) break;
			
			int cnt = 0;
			
			for(int i : lines) {
				cnt += i/mid;
			}
			
			if(cnt>=N) {
				answer = mid;
				L = mid+1;
			}else {
				R = mid-1;
			}
		}
		
		
		System.out.println(answer);
		
	}

}
