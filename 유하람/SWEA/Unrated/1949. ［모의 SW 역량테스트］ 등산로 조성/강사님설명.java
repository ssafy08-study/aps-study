
import java.util.Scanner;

public class 등산로조성 {
	/*
	 * 1. 나보다 낮은 높이 -> 공사 필요 없다
	 * 2. 나랑 같거나 높은 높이 && K만큼 깎아서 나보다 낮아지는 높이 -> 공사 가능
	 * 		- 딱 한 번 공사 가능하므로 공사 유무 매개변수로 가지고 다녀야 함.
	 * 		- 현재 높이보다 1만큼만 작아지면 된다
	 * 
	 */
	
	static int[] dr = {};
	static int[] dc = {};
	static int N,K,maxH,ans;	// N : 2차원 배열 크기, K 공사 가능 깊이
	static int[][] mountain;
	static boolean[][] visited;	// 방문 처리

public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();	//	3 ~ 8
			K = sc.nextInt();	// 1 ~ 5
			maxH = 0;	// 1 ~ 20
			ans = 0;	// 등산로 길이
			mountain = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					mountain[i][j] = sc.nextInt();
					// 높이만 찾는다.
					if(maxH < mountain[i][j])
						maxH = mountain[i][j];
				}
			}	// 입력 받으면서 최대 높이만 찾을거야! 여러개 있을 수 있어서
			
			// 전체를 순회하면서 가장 높은 봉우리에서 등산로 조성을 시작!
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					if(mountain[i][j] == maxH) {
						//공사 시작
						work(i,j, 1, true);
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}
		
	}

/////////// 높이를 들고 다닐때!

// r, c : 현재 좌표
// dist : 지금까지의 공사 길이
// skill : 공사를 할 수 있는가
private static void work(int r, int c, int dist, boolean skill) {
	if(dist > ans) ans = dist;	// 갱신할 수 있으면 갱신
	
	visited[r][c] = true;	// 방문했고
	////////////////////////////////////////
	// 4방향 탐색을 해야겠다. (상하좌우)
	for(int i=0 ; i<4 ; i++) {
		int nr = r + dr[i];
		int nc = c + dc[i];
		
		// 경계를 벗어났거나 이미 방문한 곳이라면 X
		if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
		// 1. 다음 좌표의 높이가 내 높이 보다 낮아
		if(mountain[r][c] > mountain[nr][nc]) {
			work(nr,nc,dist+1,skill);
		}
		// 2. 다음 좌표의 높이가 나와 같거나 높아
		else if(skill && mountain[r][c] > mountain[nr][nc]-K) {
			int tmp = mountain[nr][nc]; // 원상 복구 기록!
			mountain[nr][nc] = mountain[r][c] -1;
			work(nr,nc, dist+1, false);
			mountain[nr][nc] = tmp;
		}
	}
	
	////////////////////////////////////////
	visited[r][c] = false;	// 원상복구
	
}

////////////// 높이를 들고 다니지 않을 때!

private static void work2(int r, int c,int h, int dist, boolean skill) {
	if(dist > ans) ans = dist;	// 갱신할 수 있으면 갱신
	
	visited[r][c] = true;	// 방문했고
	////////////////////////////////////////
	// 4방향 탐색을 해야겠다. (상하좌우)
	for(int i=0 ; i<4 ; i++) {
		int nr = r + dr[i];
		int nc = c + dc[i];
		
		// 경계를 벗어났거나 이미 방문한 곳이라면 X
		if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
		// 1. 다음 좌표의 높이가 내 높이 보다 낮아
		if(h > mountain[nr][nc]) {
			work2(nr,nc,mountain[nr][nc],dist+1,skill);
		}
		// 2. 다음 좌표의 높이가 나와 같거나 높아
		else if(skill &&h > mountain[nr][nc]-K) {
			work2(nr,nc,mountain[r][c]-1, dist+1, false);
		}
	}
	
	////////////////////////////////////////
	visited[r][c] = false;	// 원상복구
	
}

}
