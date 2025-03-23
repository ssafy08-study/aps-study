import java.io.*;
import java.util.*;

public class Main {
    // 상하좌우 이동을 위한 방향 배열
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static class Node implements Comparable<Node> {
        int x, y, cost;
        
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int problemCount = 1;
        
        while (true) {
            int n = Integer.parseInt(br.readLine().trim());
            if (n == 0) break;
            
            int[][] cave = new int[n][n];
            
            // 동굴 정보 입력
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int minLoss = dijkstra(cave, n);
            
            // 결과 출력
            sb.append("Problem ").append(problemCount).append(": ").append(minLoss).append("\n");
            problemCount++;
        }
        
        System.out.print(sb);
    }
    
    private static int dijkstra(int[][] cave, int n) {
        // 각 칸까지 가는데 필요한 최소 비용을 저장하는 배열
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        // 시작점 설정 (시작 칸에서도 도둑루피를 잃는다는 점 주의)
        dist[0][0] = cave[0][0];
        
        // 우선순위 큐를 이용한 다익스트라 알고리즘
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, dist[0][0]));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            // 현재 저장된 비용보다 크면 무시
            if (current.cost > dist[current.x][current.y]) {
                continue;
            }
            
            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                // 동굴 범위 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    // 새로운 비용 계산
                    int newCost = current.cost + cave[nx][ny];
                    
                    // 더 적은 비용으로 이동할 수 있다면 업데이트
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new Node(nx, ny, newCost));
                    }
                }
            }
        }
        
        // 목적지까지의 최소 비용 반환
        return dist[n-1][n-1];
    }
}