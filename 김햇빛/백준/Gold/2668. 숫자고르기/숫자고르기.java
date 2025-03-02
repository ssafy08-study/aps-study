
import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static ArrayList<Integer> list; // 사이클을 이루는 시작점을 저장하는 리스트 
	static boolean[] visited;
	
	public static void dfs(int idx, int start) {
		// 사이클이 형성된 경우, 현재 노트가 시작 노드와 같다면 
		if (arr[idx] == start) {
			list.add(start); // 사이클의 시작점을 리스트에 추가 
		}
		
		// 아직 방문하지 않은 노드라면 탐색하기 
		if (!visited[arr[idx]]) {
			visited[arr[idx]] = true;
			dfs(arr[idx], start);
			visited[arr[idx]] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		for (int i=1; i<n+1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		list = new ArrayList<>();
		visited = new boolean[n+1];
		for (int i=1; i<n+1; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
