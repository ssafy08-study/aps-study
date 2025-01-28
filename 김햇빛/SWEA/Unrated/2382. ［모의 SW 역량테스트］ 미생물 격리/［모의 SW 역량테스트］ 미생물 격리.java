import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int n;
    // 상, 하, 좌, 우 1 2 3 4
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};

    static boolean inRange(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }

    // 경계 체크
    static boolean isBoundary(int r, int c) {
        return r == 0 || r == n - 1 || c == 0 || c == n - 1;
    }

    // 방향 반전
    static int reverseDirection(int dir) {
        return (dir == 1) ? 2 : (dir == 2) ? 1 : (dir == 3) ? 4 : 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            int m = sc.nextInt(); // 격리 시간
            int k = sc.nextInt(); // 군집의 수

            // 군집 정보 저장: [r, c, 군집 수, 방향]
            List<int[]> clusters = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                int cnt = sc.nextInt();
                int dir = sc.nextInt();
                clusters.add(new int[]{r, c, cnt, dir});
            }

            for (int time = 0; time < m; time++) {
                int[][][] map = new int[n][n][2]; // 0: 군집 수, 1: 최대 군집의 방향
                int[][] maxCntMap = new int[n][n]; // 셀에 존재하는 가장 큰 군집 수를 기록

                // 군집 이동
                for (int[] cluster : clusters) {
                    int r = cluster[0];
                    int c = cluster[1];
                    int cnt = cluster[2];
                    int dir = cluster[3];

                    int nr = r + dr[dir];
                    int nc = c + dc[dir];

                    // 경계에 도달한 경우
                    if (isBoundary(nr, nc)) {
                        cnt /= 2; // 군집 수 절반 감소
                        dir = reverseDirection(dir); // 방향 반전
                    }

                    if (cnt > 0) {
                        if (map[nr][nc][0] == 0) { // 처음 도착한 군집일 경우
                            map[nr][nc][0] = cnt;
                            map[nr][nc][1] = dir;
                            maxCntMap[nr][nc] = cnt;
                        } else { // 이미 군집이 도착한 셀인 경우
                            map[nr][nc][0] += cnt; // 군집 수 합산
                            // 더 큰 군집의 방향을 유지
                            if (cnt > maxCntMap[nr][nc]) {
                                maxCntMap[nr][nc] = cnt;
                                map[nr][nc][1] = dir;
                            }
                        }
                    }
                }

                // 군집 리스트 갱신
                clusters.clear();
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        if (map[r][c][0] > 0) {
                            clusters.add(new int[]{r, c, map[r][c][0], map[r][c][1]});
                        }
                    }
                }
            }

            int ans = 0;
            for (int[] cluster : clusters) {
                ans += cluster[2]; // 군집 수 합산
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
