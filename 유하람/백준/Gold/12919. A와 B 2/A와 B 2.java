import java.util.*;
import java.io.*;

public class Main {
	
	static String S;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		S = sc.next();
		String T = sc.next();
		
		if(isEqual(T)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
		
		
	} // main

	private static boolean isEqual(String t) {
		
		if(t.equals(S)) return true;
		
		if(S.length() >= t.length()) return false;
		
		boolean flag = false;
		
		if(t.charAt(t.length()-1)=='A') {
			flag = isEqual(t.substring(0,t.length()-1)) || flag;
		}
		
		if(t.charAt(0) == 'B') {
			flag = flag || isEqual(new StringBuilder(t.subSequence(1, t.length())).reverse().toString());
		}
		
		return flag;
	}

} // Main
