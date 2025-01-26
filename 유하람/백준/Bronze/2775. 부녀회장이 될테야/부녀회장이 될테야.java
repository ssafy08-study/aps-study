import java.util.*;
import java.io.*;

public class Main {

	static int[][] apt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		apt = new int[15][15];
		
		for(int i=1 ; i<15 ; i++) {
			apt[0][i] = i;
		}

		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(Cnt(k, n));
		}

	} // main

	private static int Cnt(int F, int R) {
		if (apt[F][R] != 0) {
			return apt[F][R];
		}
		
		for(int i=1 ; i<=R ; i++) {
			apt[F][R] += Cnt(F-1,i);
		}
		
		return apt[F][R];
	}

} // Main
