import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int n;
    static char[] initial;
    static char[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        initial = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        // 첫 번째 스위치를 누르지 않는 경우
        int result1 = trySwitch(false);
        // 첫 번째 스위치를 누르는 경우
        int result2 = trySwitch(true);

        int result = Math.min(result1, result2);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static int trySwitch(boolean firstSwitch) {
        char[] bulbs = initial.clone();
        int count = 0;

        // 첫 번째 스위치를 누르는 경우 처리
        if (firstSwitch) {
            switchBulb(bulbs, 0);
            count++;
        }

        // 나머지 전구 상태 변경 시도
        for (int i = 1; i < n; i++) {
            if (bulbs[i - 1] != target[i - 1]) {
                switchBulb(bulbs, i);
                count++;
            }
        }

        // 목표 상태와 일치하지 않으면 실패 처리
        if (bulbs[n - 1] != target[n - 1]) return Integer.MAX_VALUE;
        return count;
    }

    // 전구 상태를 변경하는 메서드 (자기 자신과 양 옆 토글)
    static void switchBulb(char[] bulbs, int index) {
        for (int i = index - 1; i <= index + 1; i++) {
            if (i >= 0 && i < n) {
                bulbs[i] = bulbs[i] == '0' ? '1' : '0';
            }
        }
    }
}
