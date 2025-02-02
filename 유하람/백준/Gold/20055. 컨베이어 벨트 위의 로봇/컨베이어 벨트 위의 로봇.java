import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] A = new int[2*N];
		
		for(int i=0 ; i<2*N ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] robot = new boolean[N];
		
		int stage = 0;
		
		while(K>0) {
			stage++;
			
			int tmp = A[2*N-1];
			for(int i=2*N-1 ; i>0 ; i--) {
				A[i] = A[i-1];
			}
			A[0] = tmp;
			
			for(int i=N-1 ; i>0 ; i--) {
				robot[i] = robot[i-1];
			}
			robot[0] = false;
			robot[N-1] = false;
			
			for(int i=N-2 ; i>=0 ; i--) {
				if(robot[i] && A[i+1]>0 && !robot[i+1]) {
					robot[i] = false;
					robot[i+1] = true;
					A[i+1]--;
					
					if(A[i+1]<=0) {
						K--;
					}
				}
			}
			
			robot[N-1] = false;
			
			if(A[0]>0) {
				robot[0] = true;
				A[0]--;
				if(A[0]<=0) {
					K--;
				}
			}
			
		}
		
		System.out.println(stage);
				
	} // main

} // Main
