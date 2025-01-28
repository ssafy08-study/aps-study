import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, day;
	static int[][] map;
	static boolean[][] visited;
	static int[] drs = {1, -1, 0, 0};
	static int[] dcs = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=1; tc<=T; tc++) {
        	sb.append("#").append(tc).append(" ");
        	n = Integer.parseInt(br.readLine());
        	map = new int[n][n];
        	
        	for (int i=0; i<n; i++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j=0; j<n; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	int ans = 1;
        	for (day=1; day<=100; day++) {
        		int cnt = 0;
        		visited = new boolean[n][n];
        		for (int i=0; i<n; i++) {
        			for (int j=0; j<n; j++) {
        				if (visited[i][j] || map[i][j] <= day) continue;
        				dfs(i, j);
        				cnt++;
        			}
        		}
        		ans = Math.max(ans, cnt);
        	}
        	
        	sb.append(ans).append("\n");
        }
        
        System.out.println(sb);
	}
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for (int d=0; d<4; d++) {
			int nr = r + drs[d];
			int nc = c + dcs[d];
			
			if (canGo(nr, nc)) {
				dfs(nr, nc);
			}
		}
	}
	
	static boolean canGo(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n
				&& map[r][c] > day && !visited[r][c];
	}

}
