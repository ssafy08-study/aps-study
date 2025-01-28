import java.io.*;

public class Main {
    static int ans = 0;
    static String s, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        t = br.readLine();

        dfs(t);

        System.out.println(ans);
    }

    static void dfs(String t) {
        // 기저조건
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                ans = 1;
            }
            return;
        }

        // 맨 뒤가 A로 끝날 때 (A제거)
        if (t.endsWith("A")) {
            dfs(t.substring(0, t.length()-1));
        }

        // 맨 앞이 B로 시작할 때 (뒤집고, B제거)
        if (t.startsWith("B")) {
            String newStr = t.substring(1, t.length());
            StringBuilder sb = new StringBuilder(newStr);
            dfs(sb.reverse().toString());
        }
    }
}
