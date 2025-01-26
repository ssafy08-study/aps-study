import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int N = sc.nextInt();
			
			int max = 0;
			int cnt =0;
			
			for(int i=0 ; i<N ; i++) {
				int num = sc.nextInt();
				max = Math.max(max, num);
				
				if(num<max) {
					cnt++;
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
			
		}
	}
}

// 직접 구현해 보기!
// 옆으로 돌려서 중력 작용할 때 stack 이용

