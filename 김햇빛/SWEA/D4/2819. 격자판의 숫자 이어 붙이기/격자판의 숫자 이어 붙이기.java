import java.util.*;

public class Solution {
    static int[][] maze; 
    static Set<String> result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            maze = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    maze[i][j] = sc.nextInt();
                }
            }

            result = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, 0, String.valueOf(maze[i][j]));
                }
            }

            System.out.printf("#%d %d%n", tc, result.size());
        }
        sc.close();
    }

    static void dfs(int x, int y, int depth, String path) {
        if (depth == 6) { 
            result.add(path);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                dfs(nx, ny, depth + 1, path + maze[nx][ny]);
            }
        }
    }
}