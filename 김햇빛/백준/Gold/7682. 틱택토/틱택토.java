import java.io.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            String s = br.readLine();
            if(s.equals("end")) break;

            int xCnt = 0;
            int oCnt = 0;

            // 초기화
            board = new char[3][3];
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    // 한 줄을 3*3으로 넣어주기
                    board[i][j] = s.charAt(3*i+j);
                    if (board[i][j] == 'X') {
                        xCnt++;
                    } else if (board[i][j] == 'O') {
                        oCnt++;
                    }
                }
            }

            // 게임판이 꽉 채워진 경우
            // 둘을 더하면 9이고, x가 더 많아야 함
            if (oCnt + xCnt == 9 && xCnt - oCnt == 1) {
                if (Check('X') && Check('O'))  {
                    // 둘다 빙고 완성 -> 모순
                    sb.append("invalid\n");
                } else if(Check('O')) {
                    // 꽉 찬 경우 O가 이길 수 없음
                    sb.append("invalid\n");
                } else {
                    // X가 이긴 경우
                    sb.append("valid\n");
                }
            }else{
                //게임판이 꽉 채워지지 않은 경우
                if(Check('X') && Check('O')) {
                    // 둘다 빙고 완성 -> 모순
                    sb.append("invalid\n");
                } else if(Check('X') && xCnt-oCnt==1) {
                    // X가 이겼을 땐, X가 선공이어서 무조건 O보다 하나 많아야 함
                    sb.append("valid\n");
                } else if(Check('O') && xCnt==oCnt) {
                    // O가 이겼을 땐, O가 후공이어서 X와 O의 크기가 같아야만 함
                    sb.append("valid\n");
                } else {
                    // 아무도 이기지 않았는데 말이 다 채워지지 않는 경우는 불가능
                    sb.append("invalid\n");
                }
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean Check(char tiktakto) {
        //가로가 성립할 때
        for(int i=0; i<3; i++) {
            int cnt = 0;

            for (int j=0; j<3; j++) {
                if (board[i][j] == tiktakto) cnt++;
            }

            if (cnt == 3)
                return true;
        }

        //세로로 성립할 때
        for(int j=0; j<3; j++) {
            int cnt = 0;

            for (int i=0; i<3; i++) {
                if (board[i][j] == tiktakto) cnt++;
            }

            if (cnt == 3)
                return true;
        }

        // 대각선으로 성립할 때
        if (board[0][0]==tiktakto && board[1][1]==tiktakto && board[2][2]==tiktakto)
            return true;
        if (board[0][2]==tiktakto && board[1][1]==tiktakto && board[2][0]==tiktakto)
            return true;

        return false;
    }
}