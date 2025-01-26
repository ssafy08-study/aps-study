package 그래프비용2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Contact {
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T =10;
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int E = sc.nextInt();
			int st = sc.nextInt();
			
			List<Integer>[] adjList = new ArrayList[101];	// 연락 최대 인원 100
			
			for(int i=0 ; i<101 ; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			int a = 0;
			
			for(int i=0 ; i<E ; i++) {
				if(i%2==0) {
					a = sc.nextInt();
				}else {
					int b = sc.nextInt();
					if(!adjList[a].contains(b)) {
						adjList[a].add(b);
					}
				}
			}
			
			
		
			
			answer = -1;
			
			Queue<Integer> q = new LinkedList<>();
			q.add(st);
			
			boolean visited[] = new boolean[101];
			visited[st] = true;
			
			while(!q.isEmpty()) {
				int curr = q.poll();
				
				if(adjList[curr].isEmpty()) continue;
				for(int c : adjList[curr]) {
					if(!visited[c]) {
						q.add(c);
						visited[c] = true;
					}
					System.out.println(curr+"의 자식 "+c);
				}
			}
			
			System.out.println("종료");
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		
		String ans = sb.toString();
		System.out.println(ans);
		
		
	}

}
