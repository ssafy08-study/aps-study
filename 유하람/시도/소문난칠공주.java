import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static char[][] girls;
	static int[] coor;
	static int answer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		girls = new char[5][5];
		coor = new int[25];
		answer = 0;
		int idx =0;
		
		for(int i=0 ; i<5 ; i++) {
			String row = br.readLine();
			for(int j=0 ; j<5 ; j++) {
				girls[i][j] = row.charAt(j);
				coor[idx++] = i*10+j;
			}
		}
		
		// 각 좌표 중 7 개 중복없이 뽑기
		List<Integer> list = new ArrayList<>();
		choose(0,0, list);
		
		System.out.println(answer);
		
		
	} // main

	private static void choose(int idx, int cnt, List<Integer> list) {
		if(cnt==7) {
			// 인접 & 이다솜 파 수 확인
			if(isSom(list)) {
				answer++;
			}
			return;
		}
		
		if(idx==25) {
			return;
		}
		
		// 안뽑고
		choose(idx+1,cnt,list);
		// 뽑고
		list.add(coor[idx]);
		choose(idx+1,cnt+1,list);
		
		
	}

	private static boolean isSom(List<Integer> list) {
		// 이다솜파 수
		int som = 0;
		
		// 뽑은 7개가 인접했는지 확인
		boolean[][] check = new boolean[5][5];
		for(int coor : list) {
			int r = coor/10;
			int c = coor%10;
			check[r][c] = true;
		}
		
		int cnt = 0;
		
		// 상, 하, 좌, 우
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};

		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=0 ; i<5 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				
			}
		}
		
		return false;
	}


} // Main class
