import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        
        System.out.println(canTransform(T, S) ? 1 : 0);
    }
    
    private static boolean canTransform(String t, String s) {
        if (t.equals(s)) {
            return true;
        }
        
        if (t.length() <= s.length()) {
            return false;
        }
        
        // 마지막 연산이 A를 추가한 경우
        if (t.charAt(t.length() - 1) == 'A') {
            String newT = t.substring(0, t.length() - 1);
            if (canTransform(newT, s)) {
                return true;
            }
        }
        
        // 마지막 연산이 B를 추가하고 뒤집은 경우
        if (t.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(t.substring(1));
            String newT = sb.reverse().toString();
            if (canTransform(newT, s)) {
                return true;
            }
        }
        
        return false;
    }
}