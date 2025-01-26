import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 메뉴의 총 개수 N 
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 각 메뉴의 스코빌 지수
		int[] scov = new int[N];
		for(int i=0 ; i<N ; i++) {
			scov[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		
		
	} // main


} // Main class
