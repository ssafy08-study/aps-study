import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		LinkedList<int[]>[] list = new LinkedList[N+1];
		
		for (int i = 1 ; i<=N ; i++) {
			list[i] = new LinkedList<>();
		}
		
		for(int i=1 ; i<=M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b, c});
			list[b].add(new int[] {a, c});
		}
		
		int[] price = new int[N+1];
		
		for(int i=1 ; i<=N ; i++) {
			price[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		
		pq.add(new int[] {1, 0});
		
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			
			if(tmp[1] >= price[tmp[0]]) continue;
			
			price[tmp[0]] = tmp[1];
			
			for(int[] child : list[tmp[0]]) {
				pq.add(new int[] {child[0], tmp[1]+child[1]});
			}
			
		}
		
		System.out.println(price[N]);

				
	} // main

} // Main
