import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int tc=1; tc<=10; tc++) {
        	int T = Integer.parseInt(br.readLine());
        	
        	int[][] map = new int[16][16];
        	boolean[][] visited = new boolean[16][16];
        	for (int i=0; i<16; i++) {
        		String str = br.readLine();
        		for (int j=0; j<16; j++) {
        			map[i][j] = str.charAt(j)-'0';
        		}
        	}
        	
        	int[] drs = {1, -1, 0, 0};
        	int[] dcs = {0, 0, 1, -1};
        	
        	visited[1][1] = true;
        	Queue<int[]> q = new LinkedList<>();
        	
        	int ans = 0;
        	q.add(new int[] {1, 1});
        	out : while(!q.isEmpty()) {
        		int[] curr = q.poll();
        		
        		int r = curr[0];
        		int c = curr[1];
        		
        		for (int d=0; d<4; d++) {
        			int nr = r + drs[d];
        			int nc = c + dcs[d];
        			
        			if (0 <= nr && nr < 16 && 0 <= nc && nc < 16
        					&& map[nr][nc] != 1 && !visited[nr][nc]) {
        				if (map[nr][nc] == 3) {
        					ans = 1;
        					break out;
        				}
        				visited[nr][nc] = true;
        				q.add(new int[] {nr, nc});
        				
        			}
        		}
        	}
            
        	sb.append("#").append(T).append(" ").append(ans).append("\n");
        }
        
        System.out.println(sb);
	}

}
