import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String currentState = br.readLine();
        String targetState = br.readLine();
        
        // 두 가지 경우를 시도: 첫 번째 스위치를 누르는 경우와 누르지 않는 경우
        int answer = Math.min(
            solve(N, currentState, targetState, true),
            solve(N, currentState, targetState, false)
        );
        
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
    
    // 첫 번째 스위치를 누를지 여부에 따라 최소 스위치 조작 횟수 계산
    private static int solve(int N, String currentState, String targetState, boolean pressFirst) {
        // 현재 상태를 복사
        int[] current = new int[N];
        for (int i = 0; i < N; i++) {
            current[i] = currentState.charAt(i) - '0';
        }
        
        // 목표 상태
        int[] target = new int[N];
        for (int i = 0; i < N; i++) {
            target[i] = targetState.charAt(i) - '0';
        }
        
        int count = 0;
        
        // 첫 번째 스위치를 누르는 경우
        if (pressFirst) {
            press(current, 0, N);
            count++;
        }
        
        // 두 번째 스위치부터 차례로 결정
        for (int i = 1; i < N; i++) {
            // i-1번 전구가 목표 상태와 다르면 i번 스위치를 눌러야 함
            if (current[i-1] != target[i-1]) {
                press(current, i, N);
                count++;
            }
        }
        
        // 모든 전구가 목표 상태와 일치하는지 확인
        for (int i = 0; i < N; i++) {
            if (current[i] != target[i]) {
                return Integer.MAX_VALUE; // 불가능한 경우
            }
        }
        
        return count;
    }
    
    // i번 스위치를 누르는 함수
    private static void press(int[] state, int i, int N) {
        // i-1, i, i+1 전구 상태 변경
        if (i > 0) state[i-1] = 1 - state[i-1];
        state[i] = 1 - state[i];
        if (i < N-1) state[i+1] = 1 - state[i+1];
    }
}