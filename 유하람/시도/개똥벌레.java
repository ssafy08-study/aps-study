import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 석순과 종유석의 수. 2<= N <= 200,000
		int N = sc.nextInt();
		
		// 동굴의 높이. 2<= H <= 500,000
		int H = sc.nextInt();
		
		// 석순
		int max1 = 0;
		int min1 = H;
		int[] arr1 = new int[N/2];
		
		// 종유석
		int max2 = 0;
		int min2 = H;
		int[] arr2 = new int[N/2];
		
		for(int i=0 ; i<N ; i++) {
			int tmp = sc.nextInt();
			if(i%2==0) {	// 석순
				arr1[i/2] = tmp;
			}else {		// 종유석
				tmp = H - tmp;
				arr2[i/2] = tmp;
			}
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		max1 = arr1[N/2-1];
		min1 = arr1[0];
		
		max2 = arr2[N/2-1];
		min2 = arr2[0];
		
		int answer = 0;
		int cnt = 0;
		
		if(min2>max1) {
			cnt = min2 - max1;
		}else {
			
		}
		
		
		
	}

}
