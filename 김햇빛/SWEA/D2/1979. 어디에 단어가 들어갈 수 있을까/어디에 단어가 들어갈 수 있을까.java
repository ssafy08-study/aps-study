import java.util.Scanner;

public class Solution {
	static int n, k, cnt;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();

			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			cnt = 0;
			
			// 가로 검사
			for (int i = 0; i < n; i++) {
				int length = 0;
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						length++;
					} else {
						if (length == k) cnt++;
						length = 0;
					}
				}
				if (length == k) cnt++; // 행 끝 처리
			}

			// 세로 검사
			for (int j = 0; j < n; j++) {
				int length = 0;
				for (int i = 0; i < n; i++) {
					if (map[i][j] == 1) {
						length++;
					} else {
						if (length == k) cnt++;
						length = 0;
					}
				}
				if (length == k) cnt++; // 열 끝 처리
			}

			System.out.println("#" + tc + " " + cnt);
		}

		sc.close();
	}
}
