import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int k = sc.nextInt();
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {n,0});
		
		int t = Math.abs(k-n);
		
		boolean[] visited = new boolean[100001];
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			visited[tmp[0]] = true;
			
			if(tmp[0]==k) {
				t = Math.min(tmp[1], t);
				break;
			}
			
			if(tmp[1]>t) break;
			
			if(tmp[0]*2<=100000 && !visited[tmp[0]*2]) {
				queue.add(new int[] {tmp[0]*2,tmp[1]});
			}
			
			if(tmp[0]>0 && tmp[0]<=100001 && !visited[tmp[0]-1]) {
				queue.add(new int[] {tmp[0]-1,tmp[1]+1});
			}

			if(tmp[0]>=0 && tmp[0]<100000 && !visited[tmp[0]+1]) {
				queue.add(new int[] {tmp[0]+1,tmp[1]+1});
			}
			
		}
		
		System.out.println(t);

	} // main

} // Main
