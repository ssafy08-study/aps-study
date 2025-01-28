import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, minDiff;
	static int[][] foodInfo;
	static int[] selected;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=1; tc<=T; tc++) {
        	sb.append("#").append(tc).append(" ");
        	n = Integer.parseInt(br.readLine());
        	
        	minDiff = Integer.MAX_VALUE;
        	foodInfo = new int[n][n];
        	for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<n; j++) {
					foodInfo[i][j] = Integer.parseInt(st.nextToken());
				}
			}
        	
        	selected = new int[n/2];
        	comb(0, 0);
        	
        	sb.append(minDiff).append("\n");
        }
        
        System.out.println(sb);
	}
	
	public static void comb(int idx, int sidx) {
		if (sidx == n/2) {
			int food1[] = new int[n/2];
			int food2[] = new int[n/2];
			
			boolean[] isVisited = new boolean[n];
			for (int i=0; i<n/2; i++) {
				isVisited[selected[i]] = true;
			}
			
			int f1Idx = 0;
			int f2Idx = 0;
			
			for (int i=0; i<n; i++) {
				if (isVisited[i]) {
					food1[f1Idx++] = i;
				} else {
					food2[f2Idx++] = i;
				}
			}
			
			minDiff = Math.min(calc(food1, food2), minDiff);
			
			return;
		}
		
		for (int i=idx; i< n; i++) {
			selected[sidx] = i;
			comb(i+1, sidx+1);
		}
	}
	
	static int calc(int[] a, int[] b) { 
		int sum1 = 0, sum2 = 0;
		for (int i=0; i<n/2; i++) {
			for (int j=i+1; j<n/2; j++) {
				sum1 += foodInfo[a[i]][a[j]] + foodInfo[a[j]][a[i]];
		        sum2 += foodInfo[b[i]][b[j]] + foodInfo[b[j]][b[i]];
			}
		}
		
		return Math.abs(sum1 - sum2);
	}

}
