
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int[] map = new int[w];

        for (int i = 0; i < w; i++) {
            map[i] = scanner.nextInt();
        }

        int ans = 0;
        for (int i = 1; i < w - 1; i++) {
            int leftMax = 0, rightMax = 0;

            // 왼쪽 가장 높은 블럭 찾기
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, map[j]);
            }

            // 오른쪽 가장 높은 블럭 찾기
            for (int j = i + 1; j < w; j++) {
                rightMax = Math.max(rightMax, map[j]);
            }

            // 고일 수 있는 최대 높이
            int compare = Math.min(leftMax, rightMax);

            // 현재 블록보다 높은 경우 물이 고일 수 있음
            if (map[i] < compare) {
                ans += compare - map[i];
            }
        }

        System.out.println(ans);
    }
}