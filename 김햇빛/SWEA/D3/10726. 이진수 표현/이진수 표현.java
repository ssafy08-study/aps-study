import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			// m의 이진수 표현의 마지막 n비트가 모두 1로 켜져있는지 아닌지 판별 
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			// 마지막 n개의 비트가 모두 1인지 확인할 아이 
			int mask = (1 << n) - 1;
			
			System.out.print("#" + tc + " ");
			
			// 이 둘을 & 연산했을 때 mask랑 같다면 모두 1로 켜져있는 것이므로 
			System.out.println((m & mask) == mask? "ON" : "OFF");
		}
		
	}

}
