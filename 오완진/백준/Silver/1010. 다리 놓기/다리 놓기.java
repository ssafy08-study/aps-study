import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int tmp = N;
			if (M > N) {
				N = M;
				M = tmp;
			} else if (M == N) {
				System.out.println(1);
				continue;
			}
			
			long cnt = 1;
            for (int j = 0; j < M; j++) {
                cnt *= (N - j);
                cnt /= (j + 1);
            }
			System.out.println(cnt);
						
		}
		
	}
}