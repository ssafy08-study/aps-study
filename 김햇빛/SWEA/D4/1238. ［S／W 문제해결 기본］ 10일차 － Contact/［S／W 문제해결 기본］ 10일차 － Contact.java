import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static int maxNum;
	static Set<Integer>[] graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc=1; tc<=10; tc++) {
			int n = sc.nextInt();
			int start = sc.nextInt();
			
			graph = new HashSet[101];
			for (int i=0; i<101; i++) {
				graph[i] = new HashSet();
			}
			
			for (int i=0; i<n/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				graph[from].add(to);
			}
			
			contact(start);
			
			System.out.println("#" + tc + " " + maxNum);
			
		}
	}
	
	static void contact(int st) {
		boolean[] visited = new boolean[101];
		Queue<Integer> q = new LinkedList<>();
		q.add(st);
		visited[st] = true;
		
		while (!q.isEmpty()) {
			int childSize = q.size();
			
			maxNum = 0;
			for (int i=0; i<childSize; i++) {
				int curr = q.poll();
				
				maxNum = Math.max(maxNum, curr);
				
				for (int num : graph[curr]) {
					if (visited[num]) continue;
					visited[num] = true;
					q.add(num);
				}
			}
		}
	}
	
}
