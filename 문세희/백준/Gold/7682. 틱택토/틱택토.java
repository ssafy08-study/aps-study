import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    // 3x3 게임판
    static char[][] board = new char[3][3];
    static int xCnt;
    static int oCnt;
    static char tmp;
    static boolean isValid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = br.readLine()).equals("end")) {
            xCnt = 0;
            oCnt = 0;
            isValid = true;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    // 게임판에 입력 순서대로 할당
                    tmp = line.charAt(r * 3 + c);
                    board[r][c] = tmp;
                    if (tmp == 'X') {
                        xCnt++;
                    } else if (tmp == 'O') {
                        oCnt++;
                    }
                }
            }

            // 1. O의 개수가 더 많거나, X가 더 많되 2개 이상 많으면 불가능
            if (oCnt > xCnt || xCnt > oCnt + 1) {
                isValid = false;

            // 2. 미완성의 경우 - 이미 틱/택/토 중 하나가 완성된 상태에서 게임이 이어진 것이면 불가능
            // 즉 틱/택/토를 완성하지 못한 문자가 완성한 문자보다 개수가 많은 경우
            } else if (findValid('X') && oCnt == xCnt) {
                isValid = false;
            } else if (findValid('O') && xCnt > oCnt) {
                isValid =false;

            // 3. 미완성의 경우 - 틱/택/토 어느 하나 진행되지 않은 경우
            } else if (oCnt + xCnt < 9 && !findValid('X') && !findValid('O')) {
                isValid = false;
            }

            System.out.println(isValid ? "valid" : "invalid");
        }
    }

    static boolean findValid(char player) {
        boolean tic;
        boolean tac;
        boolean toe;

        // 가로 검증
        for (int c = 0; c < 3; c++) {
            tic = true;
            for (int r = 0; r < 3; r++) {
                if (board[r][c] != player) {
                    tic = false;
                    break;
                }
            }
            if (tic) {
                return true;
            }
        }

        // 세로 검증
        for (int r = 0; r < 3; r++) {
            tac = true;
            for (int c = 0; c < 3; c++) {
                if (board[r][c] != player) {
                    tac = false;
                    break;
                }
            }
            if (tac) {
                return true;
            }
        }

        // 대각선 검증
        toe = true;
        for (int i = 0; i < 3; i++) {
            if (board[i][i] != player) {
                toe = false;
                break;
            }
        }

        if (toe) {
            return true;
        }

        toe = true;
        for (int i = 0; i < 3; i++) {
            if (board[i][2 - i] != player) {
                toe = false;
                break;
            }
        }

        if (toe) {
            return true;
        }


        return false;
    }
}
