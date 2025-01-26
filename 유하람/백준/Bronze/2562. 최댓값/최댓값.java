import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		int[] nums = new int[9];
		
		int max = 0;
		int maxIdx = 0;
		
		for(int i=0 ; i<9 ; i++) {
			nums[i]=sc.nextInt();
			if(max<nums[i]) {
				max = nums[i];
				maxIdx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(maxIdx+1);
		
		
	} // main


}
