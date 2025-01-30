import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			int[] binsu = new int[1000];
			
			for (int i = 0; i < binsu.length; i++) {
				binsu[i] = sc.nextInt();
			}
			
			// 원소의 범위(최댓값 K) 확인
			int K = -1;
			for (int i = 0; i < binsu.length; i++) {
				K = Math.max(K, binsu[i]);
			}
			
			// count 배열 index : 0 ~ K
			// binsu[i]에 해당하는 index++
			int[] count = new int[K + 1];

			for (int i = 0; i < binsu.length; i++) {
				count[binsu[i]]++;
			}
			
			int idx = -1;
			int max = -1;
			for (int i = 0; i < count.length; i++) {
				// = 등호 -> 최빈수가 여러개면 가장 큰 idx 출력하도록
				if (count[i] >= max) {
					max = count[i];
					idx = i;
				}
			}
			
			System.out.printf("#%d " + idx, N);
			System.out.println();
			
		}
		
	}
}