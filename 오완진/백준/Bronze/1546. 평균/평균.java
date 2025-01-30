import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		double[] SJ = new double[N];
		double max = 0;
		double sum = 0;
		double avg = 0;
		
		for (int i = 0; i < N; i++) {
			SJ[i] = sc.nextInt();
			if (SJ[i] > max) max = SJ[i];
		}
		
		for (int j = 0; j < N; j++) {
			SJ[j] = ( SJ[j] / max ) * 100;
			sum += SJ[j];
		}
		
		avg = sum / N;
		System.out.println(avg);
		
	}
}