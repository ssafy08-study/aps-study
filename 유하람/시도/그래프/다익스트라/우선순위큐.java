import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 다익스트라_pq_try {
	
	static class Node implements Comparable<Node>{
		int V;
		int pathCost;
		
		Node(int next, int pathCost){
			this.V = next;
			this.pathCost = pathCost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.pathCost, o.pathCost);
		}
		
		
	}
	
	static int V,E;
	static List<Node>[] edges;
	static int[] dist;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		edges = new LinkedList[V];
		dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=0 ; i<V ; i++) {
			edges[i] = new LinkedList<>();
		}
		
		for(int i=0 ; i<E ; i++) {
			edges[sc.nextInt()].add( new Node(sc.nextInt(), sc.nextInt()));
		}
		
		dijkstra(0);
		
		System.out.println(Arrays.toString(dist));
		
	}	// main
	

	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			
			Node curr = pq.poll();	// (V,pathCost)
			
			if(curr.pathCost >= dist[curr.V]) continue;
			
			dist[curr.V] = curr.pathCost;
			
			for(Node next : edges[curr.V]) {
				pq.add(new Node(next.V, next.pathCost+dist[curr.V]));
			}
			
			
		}
		
		
	}



	static String input = "6 11\r\n"
			+ "0 1 4\r\n"
			+ "0 2 2\r\n"
			+ "0 5 25\r\n"
			+ "1 3 8\r\n"
			+ "1 4 7\r\n"
			+ "2 1 1\r\n"
			+ "2 4 4\r\n"
			+ "3 0 3\r\n"
			+ "3 5 6\r\n"
			+ "4 3 5\r\n"
			+ "4 5 12\r\n"
			+ "";

}
