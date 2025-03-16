import java.util.*;
import java.io.*;

public class Main {
    // 상하좌우 이동을 위한 방향 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, L, R;
    static int[][] A;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        A = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(solution());
    }
    
    // 인구 이동 시뮬레이션
    public static int solution() {
        int days = 0;
        
        while (true) {
            boolean moved = false;
            boolean[][] visited = new boolean[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = new ArrayList<>();
                        int totalPopulation = bfs(i, j, union, visited);
                        
                        // 연합이 2개 국가 이상인 경우 인구 이동 발생
                        if (union.size() > 1) {
                            moved = true;
                            int newPopulation = totalPopulation / union.size();
                            
                            // 연합 국가에 인구 배분
                            for (int[] pos : union) {
                                A[pos[0]][pos[1]] = newPopulation;
                            }
                        }
                    }
                }
            }
            
            // 인구 이동이 없으면 종료
            if (!moved) {
                break;
            }
            
            // 인구 이동 일수 증가
            days++;
        }
        
        return days;
    }
    
    // BFS로 연합 찾기
    public static int bfs(int startX, int startY, List<int[]> union, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        int totalPopulation = A[startX][startY];
        union.add(new int[]{startX, startY});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            // 상하좌우 이동
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                // 범위 체크
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    // 인구 차이가 L 이상 R 이하인 경우 국경선 열기
                    int diff = Math.abs(A[x][y] - A[nx][ny]);
                    if (L <= diff && diff <= R) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        union.add(new int[]{nx, ny});
                        totalPopulation += A[nx][ny];
                    }
                }
            }
        }
        
        return totalPopulation;
    }
}