import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] top = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1 ; i<=N ; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<int[]> stack = new Stack<>();
		int[] ans = new int[N + 1];

		for (int i = 1; i <= N; i++) {
		    while (!stack.isEmpty() && stack.peek()[1] <= top[i]) {
		        stack.pop();
		    }

		    if (!stack.isEmpty()) {
		        ans[i] = stack.peek()[0];
		    }

		    stack.push(new int[]{i, top[i]});
		}

		
		StringBuffer sb = new StringBuffer();
		
		sb.append(ans[1]);
		
		for(int i=2 ; i<=N ; i++) {
			sb.append(" ").append(ans[i]);
		}
		
		System.out.println(sb);

				
	} // main

} // Main
