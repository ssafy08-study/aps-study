import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 상, 하, 좌, 우 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int R, C;
    static char[][] board;
    static boolean[] visited = new boolean[26];
    static int maxCount = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        board = new char[R][C];
        
        // 보드 입력 받기
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        // 시작 위치 (0, 0)에서 DFS 시작
        // 첫 번째 칸의 알파벳도 방문 처리
        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        
        System.out.println(maxCount);
    }
    
    static void dfs(int x, int y, int count) {
        // 현재까지의 이동 칸 수가 최대값보다 크면 갱신
        maxCount = Math.max(maxCount, count);
        
        // 상하좌우 네 방향으로 이동 시도
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 보드 범위 내이고
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                int alphabetIndex = board[nx][ny] - 'A';
                
                // 해당 알파벳을 아직 방문하지 않았다면
                if (!visited[alphabetIndex]) {
                    // 방문 처리
                    visited[alphabetIndex] = true;
                    // 다음 위치로 이동
                    dfs(nx, ny, count + 1);
                    // 백트래킹 (방문 취소)
                    visited[alphabetIndex] = false;
                }
            }
        }
    }
}