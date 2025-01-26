import java.util.*;
import java.io.*;

public class Main {

	static int[][] DP = new int[10001][4];
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		DP[1][1] = 1;
		DP[2][1] = 1;
		DP[2][2] = 1;
		DP[3][1] = 1;
		DP[3][2] = 1;
		DP[3][3] = 1;
		
		for(int i=4 ; i<=10000 ; i++) {
			DP[i][1] = DP[i-1][1];
			DP[i][2] = DP[i-2][1] + DP[i-2][2];
			DP[i][3] = DP[i-3][1] + DP[i-3][2] + DP[i-3][3];
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0 ; tc<T ; tc++) {
			int n = sc.nextInt();
			
			sb.append(DP[n][1]+DP[n][2]+DP[n][3]+"\n");
			
		}
		
		System.out.println(sb);


	} // main

} // Main
