import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		boolean[] num = new boolean[31];
		
		for(int i=0 ; i<28 ; i++) {
			num[sc.nextInt()] = true;
		}
		
		for(int i=1 ; i<=30 ; i++) {
			if(!num[i]) System.out.println(i);
		}

	} // main

} // Main
