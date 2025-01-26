import java.util.Arrays;
import java.util.Scanner;

public class 보호필름2 {
	
	/*
	 * 약품을 주입하지 않아도
	 * 		A약품이 가득 차 있는 행
	 * 		B약품이 가득 차 있는 행 
	 * 	이용 가능
	 */

	
	static int D,W,K; // D : 행 3~13 , W : 열 1~20, K : 통과 기준 1~D
	static int[][] film; // 보호필름 저장
	static int ans;	//  정답(최소 투약 횟수)
	static int[] A,B;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1 ; tc<=T ; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];
			A = new int[W];
			B = new int[W];
			Arrays.fill(B, 1);
			
			
			
			for(int i=0 ; i<D ; i++) {
				for(int j=0 ; j<W ; j++) {
					film[i][j] = sc.nextInt();
				}
			}// 필름입력 완료
			
			ans = K; // 통과 기준인 K만큼 쓸 수 있어!
			
			makeFilm(0,0);
			
			
			
			
		}// tc
		
		
		
		
	}// main
	
	// idx : 현재 약을 주입하려고 하는 행
	// cnt : 약품을 주입한 횟수
	private static void makeFilm(int idx, int cnt) {
		if(idx==D) {
			// 이제 확인을 하겠다.
			if(isOk()) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		// 1. 주입 X
		makeFilm(idx+1, cnt);
		
		int[] tmp = film[idx];
		
		// 2. 주입 A
		film[idx] = A;
		makeFilm(idx+1, cnt+1);
		
		// 3. 주입 B
		film[idx] = B;
		makeFilm(idx+1, cnt+1);
		
		film[idx] = tmp;

		
	}
	
	
	// 모든 열이 연속된 특성이 K개 인가?
	private static boolean isOk() {
		// 열을 고정시킨 상태에서 검사를 할꺼야
		for(int c=0 ; c<W ; c++) {
			boolean flag = false;
			int cnt = 1;
			
			for(int r=1 ; r<D ; r++) {
				if(film[r][c] == film[r-1][c]) cnt++;	// 이전과 나와 같다면 카운트
				else cnt=1;
				
				if(cnt>=K) {
					flag = true;
					break;
				}
			} // 해당 열 검사 완료
			if(!flag) return false;	// 해당 열이 통과하지 못했다. 이후는 볼 필요 없어
		}// 모든 열 검사 완료
		return true;
		
	}

}
