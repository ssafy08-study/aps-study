import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와토네이도 {
	
	static int N;
	static int[][] ground;
	
	// 좌 하 우 상
	static int[] dr = {0, 1, 0 ,-1};
	static int[] dc = {-1, 0, 1, 0};
	
	// 지금 위치, 지금 방향
	static int r;
	static int c;
	static int d;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		N = Integer.parseInt(n);
		
		r = N/2;
		c = N/2;
		d = 0;
		
		ground = new int[N][N];
		
		int before = 0;
		
		for(int i=0 ; i<N ; i++) {
			String row = br.readLine();
			StringTokenizer st = new StringTokenizer(row);
			for(int j=0 ; j<N ; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				before += ground[i][j];
			}
		}
		
		for(int i=1 ; i<=N ; i++) {
			for(int j=0 ; j<i ; j++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				wind(nr,nc);
				r = nr;
				c = nc;
			}
			d = (d+1) % 4;
			for(int k=0 ; k<i ; k++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				wind(nr,nc);
				r = nr;
				c = nc;
			}
			d = (d+1) % 4;
		}
		
		int after = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				after += ground[i][j];
			}
		}
		
		int answer = before - after;
		
		System.out.println(answer);
		
	}

	private static void wind(int nr, int nc) {
		int tmp = ground[nr][nc];	// y의 모래 양
		
		if(d==1 || d==3) { // 상 하
			
			
			
			
		}else {	// 좌 우
			
			
			
			
			
		}
		
	}

	private static boolean inGround(int i, int j) {
		if(i>=0 && i<N && i>=0 && i<N) {
			return true;
		}
		return false;
	}

}
