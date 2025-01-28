import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    static int bfs(int start, int target) {
        int[] dist = new int[100001];
        
        // / 초기값 -1로 설정 (방문하지 않은 상태)
        Arrays.fill(dist, -1); 

        Deque<Integer> deque = new ArrayDeque<>();
        dist[start] = 0; // 시작 위치의 시간은 0
        deque.add(start); // 시작 위치를 큐에 추가

        while (!deque.isEmpty()) {
            int current = deque.poll();

            if (current == target) {
                return dist[current];
            }

            // 세 가지 이동 방식 처리
            for (int next : new int[] {current * 2, current - 1, current + 1}) {
                // 범위를 벗어나지 않고, 방문하지 않은 위치인지 확인
                if (next >= 0 && next <= 100000 && dist[next] == -1) {
                    // 곱하기 이동은 시간이 증가하지 않으므로 deque 앞에 추가
                    if (next == current * 2) {
                        dist[next] = dist[current]; // 시간 그대로
                        deque.addFirst(next); // 우선 처리
                    } else {
                        dist[next] = dist[current] + 1; // 시간 증가
                        deque.addLast(next); // 일반 처리
                    }
                }
            }
        }

        return -1; // 도달 불가능한 경우
    }
}
