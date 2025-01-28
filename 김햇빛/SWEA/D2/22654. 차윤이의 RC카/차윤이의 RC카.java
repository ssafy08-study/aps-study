import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
        	sb.append("#").append(tc).append(" ");
        	
        	int n = Integer.parseInt(br.readLine());
        	
        	int startR = 0, startC = 0;
        	char[][] map = new char[n][n];
        	for (int i=0; i<n; i++) {
        		String str = br.readLine();
        		for (int j=0; j<n; j++) {
        			map[i][j] = str.charAt(j);
        			if (map[i][j] == 'X') {
        				startR = i;
        				startC = j;
        			}
        		}
        	}
        	
        	// 상 우 하 좌 
        	int[] drs = {-1, 0, 1, 0};
        	int[] dcs = {0, 1, 0, -1};
        	
        	int q = Integer.parseInt(br.readLine());
        	
        	for (int i=0; i<q; i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		int len = Integer.parseInt(st.nextToken());
                String cmd = st.nextToken();
        		
        		int ans = 0;
        		int d = 0; // 상으로 시작 
        		int r = startR;
        		int c = startC;
        		
        		for (int j=0; j<len; j++) {
        			if (cmd.charAt(j) == 'A') {
        				int nr = r + drs[d];
        				int nc = c + dcs[d];
        				
        				if (0 <= nr && nr < n && 0 <= nc && nc < n
        						&& map[nr][nc] != 'T') {
        					r += drs[d];
        					c += dcs[d];
        				}
        				
        			} else if (cmd.charAt(j) == 'L') {
        				d = (d+3) % 4;
        			} else { // R
        				d = (d+1) % 4;
        			}
        			
        		}
        		
        		if (map[r][c] == 'Y') {
					ans = 1;
				}
        		
        		sb.append(ans).append(" ");
        	}
        	
        	sb.append("\n");
        }
        
        System.out.println(sb);
	}

}
