import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tunnel {
	int type; // 구조물의 타입
	int r, c; // 위치
	boolean up, down, left, right; // 상하좌우
	
	public Tunnel(int type, int r, int c, boolean up, boolean down, boolean left, boolean right) {
		this.type = type;
		this.r = r;
		this.c = c;
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}
	
}

public class Solution {
	static int N, M;
	static Tunnel[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 세로 크기
			M = Integer.parseInt(st.nextToken()); // 가로 크기
			int R = Integer.parseInt(st.nextToken()); // 세로 위치
			int C = Integer.parseInt(st.nextToken()); // 가로
			int L = Integer.parseInt(st.nextToken()); // 탈출에 소요된 시간
			
			map = new Tunnel[N][M];
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<M; j++) {
					int key = Integer.parseInt(st.nextToken());
					switch (key) {
					case 1:
						map[i][j] = new Tunnel(1, i, j, true, true, true, true);
						break;
					case 2:
						map[i][j] = new Tunnel(2, i, j, true, true, false, false);
						break;
					case 3:
						map[i][j] = new Tunnel(3, i, j, false, false, true, true);
						break;
					case 4:
						map[i][j] = new Tunnel(4, i, j, true, false, false, true);
						break;
					case 5:
						map[i][j] = new Tunnel(5, i, j, false, true, false, true);
						break;
					case 6:
						map[i][j] = new Tunnel(6, i, j, false, true, true, false);
						break;
					case 7:
						map[i][j] = new Tunnel(7, i, j, true, false, true, false);
						break;

					default: // 0
						map[i][j] = new Tunnel(0, i, j, false, false, false, false);
						break;
					}
				}
			} // 입력 끝
			
			// 큐에 시작지점을 넣고 시작
			Queue<Tunnel> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			
			// 처음 위치를 넣기
			q.add(map[R][C]);
			
			int cnt = 0;
			
			// 상 하 좌 우
			int[] dxs = {-1, 1, 0, 0};
			int[] dys = {0, 0, -1, 1};
			
			// 큐가 비었거나, 입력받은 시간이 될 때까지 반복
			for (int i=0; i<L; i++) {
				if (q.isEmpty()) break;
				int childSize = q.size();
				
				for (int k=0; k<childSize; k++) {
					Tunnel curr = q.poll();
					if (visited[curr.r][curr.c]) continue;
//					System.out.println(curr.r + " " + curr.c + "시간: " + i);
					visited[curr.r][curr.c] = true; // 방문 처리
					cnt++;
					
					for (int d=0; d<4; d++) {
						int nx = curr.r + dxs[d];
						int ny = curr.c + dys[d];
						
						// 갈 수 없거나 이미 방문했다면 continue
						if (!inRange(nx, ny) 
								|| !canGo(d, nx, ny, curr.r, curr.c) 
								|| visited[nx][ny]) continue;
						
						// 이동이 가능한 경우에는 터널의 정보를 큐에 저장
						q.add(map[nx][ny]);
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static boolean inRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
	
	static boolean canGo(int d, int nx, int ny, int r, int c) {
		// 상, 하, 좌, 우에 따라 처리해주기
		switch (d) {
		case 0:
			if (map[nx][ny].down && map[r][c].up)
				return true;
			break;
		case 1:
			if (map[nx][ny].up && map[r][c].down)
				return true;
			break;
		case 2:
			if (map[nx][ny].right && map[r][c].left)
				return true;
			break;
		default: // 3
			if (map[nx][ny].left && map[r][c].right)
				return true;
			break;
		}
		
		return false;
	}

}