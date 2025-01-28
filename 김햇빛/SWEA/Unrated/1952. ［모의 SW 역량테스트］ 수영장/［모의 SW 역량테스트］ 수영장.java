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
        	
        	st = new StringTokenizer(br.readLine());
            int[] fee = new int[4];
            for (int i = 0; i < 4; i++) {
                fee[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            int[] plan = new int[13];
            for (int i = 1; i <= 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }
        	
        	int[] dp = new int[13];
        	
        	for (int i=1; i<=12; i++) {
        		dp[i] = dp[i-1] + Math.min(plan[i] * fee[0], fee[1]);
        		
        		if (i >= 3) {
        			dp[i] = Math.min(dp[i], dp[i-3] + fee[2]);
        		}
        	}
        	
        	dp[12] = Math.min(dp[12], fee[3]);
        	sb.append(dp[12]).append("\n");
        }
        
        System.out.println(sb);
	}

}
