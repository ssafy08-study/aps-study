import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int[] drs = {0, 0, 1, -1, 1, 1, -1, -1};
	static int[] dcs = {1, -1, 1, -1, -1, 0, 0, 1};
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0)
				break;
			
			// 지도 입력받기 
			map = new int[h][w];
			for (int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[h][w];
			
			int cnt = 0;
			for (int i=0; i<h; i++) {
				for (int j=0; j<w; j++) {
					// 이미 방문했거나, 바다라면 건너뜀 
					if (visited[i][j] || map[i][j] == 0) 
						continue;
					
					dfs(i, j);
					cnt++;
				}
			}
			
			System.out.println(cnt);
        }
		
	}
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for (int d=0; d<8; d++) {
			int nr = r + drs[d];
			int nc = c + dcs[d];
			
			if (canGo(nr, nc)) {
				dfs(nr, nc);
			}
		}
	}
	
	static boolean canGo(int r, int c) {
		return 0 <= r && r < h && 0 <= c && c < w
				&& !visited[r][c] && map[r][c] == 1;
	}
}
