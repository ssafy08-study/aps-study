import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer> restPlace;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 현재 휴게소 개수 N
		int N = Integer.parseInt(st.nextToken());
		
		// 더 지으려고 하는 휴게소 개수 M
		int M = Integer.parseInt(st.nextToken());
		
		// 고속도로 길이 L
		int L = Integer.parseInt(st.nextToken());
		
		// 현재 휴게소 위치
		restPlace = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			restPlace.add(Integer.parseInt(st.nextToken()));
		}
		
		// 휴게소가 없는 구간의 길이 최대값
		int max = 0;
		
		// M 번 휴게소 세우기
		for(int i=0 ; i<M ; i++) {
			
		}
		
		
	} // main


} // Main class
