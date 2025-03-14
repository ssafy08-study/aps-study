import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R; // N: 맵의 크기, L과 R: 인구 차이 기준
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) { // 아직 방문하지 않은 칸이면
                        if (bfs(i, j)) { // BFS 탐색으로 연합 형성 및 인구 이동
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) break; // 인구 이동이 없으면 종료
            days++;
        }

        System.out.println(days);
    }

    static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>(); 

        queue.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        int sum = map[x][y];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                 // 맵 범위 밖이거나 이미 방문한 경우
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]); 

                if (diff >= L && diff <= R) { // 인구 차이가 L 이상 R 이하이면 연합 형성
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    sum += map[nx][ny];
                }
            }
        }

        if (union.size() == 1) return false; // 연합이 형성되지 않으면 false 반환

        int avg = sum / union.size();

        for (int[] pos : union) {
            map[pos[0]][pos[1]] = avg; // 연합 내 모든 칸에 평균 인구 수 적용
        }

        return true;
    }
}
