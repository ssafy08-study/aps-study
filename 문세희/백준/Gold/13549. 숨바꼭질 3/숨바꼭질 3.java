import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(find(N, K));
    }

    public static int find(int N, int K) {
        // 수빈이가 동생보다 앞에 있을 경우
        if (N >= K) {
            return N - K;
        }

        Queue<Integer> posQueue = new LinkedList<>();
        Queue<Integer> timeQueue = new LinkedList<>();
        boolean[] visited = new boolean[MAX];

        posQueue.offer(N);
        timeQueue.offer(0);
        visited[N] = true;

        while (!posQueue.isEmpty()) {
            int pos = posQueue.poll();
            int time = timeQueue.poll();

            if (pos == K) return time;

            // 순간이동
            if (pos * 2 < MAX && !visited[pos * 2]) {
                visited[pos * 2] = true;
                posQueue.offer(pos * 2);
                timeQueue.offer(time);
            }

            // 뒤로 가기
            if (pos - 1 >= 0 && !visited[pos - 1]) {
                visited[pos - 1] = true;
                posQueue.offer(pos - 1);
                timeQueue.offer(time + 1);
            }

            // 앞으로 가기
            if (pos + 1 < MAX && !visited[pos + 1]) {
                visited[pos + 1] = true;
                posQueue.offer(pos + 1);
                timeQueue.offer(time + 1);
            }
        }

        return -1;
    }


}