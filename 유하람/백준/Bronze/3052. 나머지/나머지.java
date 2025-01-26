import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {


	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		Set<Integer> set = new HashSet<>();
		
		for(int i=0 ; i<10 ; i++) {
			int num = sc.nextInt();
			set.add(num%42);
		}
		
		System.out.println(set.size());
		
	} // main


}
