
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[N * 2]; // 벨트 내구도 배열
        boolean[] robot = new boolean[N]; // 로봇 존재 여부 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int level = 0;

        while (true) {
            level++;

            // 1단계: 벨트와 로봇 한 칸 회전
            int tmp = belt[2 * N - 1]; // 벨트 마지막 칸 내구도 저장
            for (int i = 2 * N - 1; i > 0; i--) {
                belt[i] = belt[i - 1]; // 벨트 이동
            }
            belt[0] = tmp; // 첫 번째 칸에 내구도 설정

            // 로봇도 한 칸씩 회전
            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1]; // 로봇 이동
            }
            robot[0] = false; // 첫 번째 칸에 로봇은 없음
            robot[N - 1] = false; // 마지막 칸의 로봇 내리기

            // 2단계: 로봇 이동
            for (int i = N - 2; i >= 0; i--) { // 로봇이 한 칸씩 이동
                if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
                    robot[i] = false;
                    robot[i + 1] = true;
                    belt[i + 1]--; // 내구도 감소
                }
            }

            // 3단계: 첫 번째 칸에 로봇 올리기
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }

            // 4단계: 내구도가 0인 칸 카운트
            int cnt = 0;
            for (int i = 0; i < N * 2; i++) {
                if (belt[i] == 0) {
                    cnt++;
                }
            }
            if (cnt >= K) {
                break; // 내구도가 0인 칸이 K개 이상이면 종료
            }
        }

        System.out.println(level); // 결과 출력
    }
}
