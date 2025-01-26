import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] room;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 집의 크기, 3 <= N <=16
		N = Integer.parseInt(br.readLine());

		// 집의 상태
		room = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료
		
		// [파이프 방향][r][c]
		// 파이프 방향 : 오른쪽, 아래, 대각선
		int[][][] DP = new int[3][N][N];
		DP[0][0][1] = 1;
		
		for(int r=0 ; r<N ; r++) {
			for(int c=2 ; c<N ; c++) {
				if(isOk(r,c)) {
					// 위에서 오는 경우
					
					// 왼쪽에서 오는 경우
					
					// 대각선에서 오는 경우
					
				}
			}
		}

	} // main

	private static boolean isOk(int r, int c) {

		if (r >= 0 && r < N && c >= 0 && c < N && room[r][c] != 1) {
			return true;
		}
		return false;
	}

} // Main class
