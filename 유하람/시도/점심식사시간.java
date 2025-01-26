package 그래프비용1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Strpackage 그래프비용1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 점심식사시간 {
	
	static class floor{
		floor next;
		floor prev;
		int person;
		
		floor(){}
		floor(int person){
			this.person = person;
		}
	}
	
	static class stair{
		floor start = new floor();
		floor finish = new floor();
		int size;
		int cnt;
		int r;
		int c;
		
		stair(int size, int r, int c){
			finish.next = start;
			start.prev = finish;
			this.size = size;
			this.r = r;
			this.c = c;
		}
		
		void addP(int person){
			floor p = new floor(person);
			p.prev = start.prev;
			p.next = start;
			start.prev.next = p;
			start.prev = p;
			cnt++;
		}
		
		void removeP() {
			finish.next.next.prev = finish;
			finish.next = finish.next.next;
			cnt--;
		}
		
		boolean isEmpty() {
			if(cnt==0)
				return true;
			return false;
		}
		
		boolean isFull() {
			if(cnt>3)
				return true;
			return false;
		}
		
		
	}
	
	static stair[] stairs = new stair[2];
	static List<int[]> people;
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String t = br.readLine();
		int T = Integer.parseInt(t);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String N = br.readLine();
			int n = Integer.parseInt(N);
			
			people = new LinkedList<>();
			
			int sidx = 0;	// stairs 인덱스
			
			for(int r=0 ; r<n ; r++) {
				String row = br.readLine();
				StringTokenizer st = new StringTokenizer(row);
				for(int c=0 ; c<n ; c++) {
					int tmp = Integer.parseInt(st.nextToken());
					
					if(tmp==1) {	// 사람인 경우
						int[] person = {r,c};
						people.add(person);
					}
					
					if(tmp>1) {		// 계단인 경우
						stair newStair = new stair(r,c,tmp);
						stairs[sidx++] = newStair;
					}
				}
			}
			
			answer = Integer.MAX_VALUE;
			
			List<int[]> aList = new LinkedList<>();
			List<int[]> bList = new LinkedList<>();
			
			choose(aList, bList);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		
		String ans = sb.toString();
		System.out.println(ans);
		
		
	}
	
	// aList : 0번 stair 선택
	// bList : 1번 stair 선택
	private static void choose(List<int[]> aList, List<int[]> bList) {
		
		if(people.size()==0) {
			int[] length1 = sortList(aList, 0);
			int[] length2 = sortList(bList, 1);
			
			int time1 = 0;
			int time2 = 0;
			
			if(length1.length==0) {
				time2 = takeStair(length2.length-1, length2, stairs[1]);
			}else if(length2.length==0) {
				time1 = takeStair(length1.length-1, length1, stairs[0]);
			}else {
				time1 = takeStair(length1.length-1, length1, stairs[0]);
				time2 = takeStair(length2.length-1, length2, stairs[1]);
			}
			
			int time = Math.max(time1, time2);
			
			answer = Math.min(answer, time);
			return;
		}
		
		// length1에 포함
		int[] tmp1 = people.remove(0);
		aList.add(tmp1);
		choose(aList, bList);
		people.add(0, tmp1);;
		
		// length2에 포함
		int[] tmp2 = people.remove(people.size()-1);
		bList.add(tmp2);
		choose(aList,bList);
		people.add(tmp2);
		
		
	}

	private static int takeStair(int idx, int[] length, stair thisStair) {
		if(idx==0) {
			int time = length[0]+thisStair.size+1;
			return time;
		}else if(idx>0 && idx<3){
			int time1 = length[idx];
			int time2 = takeStair(idx-1,length,thisStair);
			return Math.max(time1, time2)+thisStair.size+1;
		}
		else {
			// 나의 이동 시간
			int time1 = length[idx];
			// 전전전 사람 계단 이용 완료 시간
			int time2 = takeStair(idx-3,length,thisStair);
			
			return Math.max(time1, time2)+thisStair.size+1;
		}
	}

	private static int[] sortList(List<int[]> aList, int i) {
		
		int sr = stairs[i].r;
		int sc = stairs[i].c;
		
		int n = aList.size();
		int[] result = new int[n];
		int idx = 0;
		for(int[] p : aList) {
			int r = p[0];
			int c = p[1];
			int len = Math.abs(sr - r) + Math.abs(sc - c);
			result[idx++] = len;
		}
		
		Arrays.sort(result);
		
		return result;
	}
	
	



}
ingTokenizer;

public class 점심식사시간 {
	
	static class floor{
		floor next;
		floor prev;
		int[] person;
		
		floor(){}
		floor(int[] person){
			this.person = person;
		}
	}
	
	static class stair{
		floor start;
		floor finish;
		int size;
		int cnt;
		int r;
		int c;
		
		stair(int size, int r, int c){
			finish.next = start;
			start.prev = finish;
			this.size = size;
			this.r = r;
			this.c = c;
		}
		
		void addP(int[] person){
			floor p = new floor(person);
			p.prev = start.prev;
			p.next = start;
			start.prev.next = p;
			start.prev = p;
			cnt++;
		}
		
		void removeP() {
			finish.next.next.prev = finish;
			finish.next = finish.next.next;
			cnt--;
		}
		
		boolean isEmpty() {
			if(cnt==0)
				return true;
			return false;
		}
		
		boolean isFull() {
			if(cnt==size)
				return true;
			return false;
		}
		
		
	}
	
	static int pCnt;
	static stair[] stairs = new stair[2];
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String t = br.readLine();
		int T = Integer.parseInt(t);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String N = br.readLine();
			int n = Integer.parseInt(N);
			
			int sidx = 0;	// stairs 인덱스
			pCnt = 0;
			
			for(int r=0 ; r<n ; r++) {
				String row = br.readLine();
				StringTokenizer st = new StringTokenizer(row);
				for(int c=0 ; c<n ; c++) {
					int tmp = Integer.parseInt(st.nextToken());
					
					if(tmp==1) {	// 사람인 경우
						pCnt++;
					}
					
					if(tmp>1) {		// 계단인 경우
						stair newStair = new stair(r,c,tmp);
						stairs[sidx++] = newStair;
					}
				}
			}
			
			
			
			answer = Integer.MAX_VALUE;
			
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		
		String ans = sb.toString();
		System.out.println(ans);
		
		
	}


}
