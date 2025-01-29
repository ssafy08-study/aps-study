import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
                
            //k가 1일때
            if(k == 1) {
                System.out.println("1 1");
                continue;
            }
            
            // 각 문자의 등장 횟수를 저장할 배열
            int[] alpha = new int[26];
            for (int j = 0; j < str.length(); j++) {
                alpha[str.charAt(j) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            // 문자열에서 k번 이상 등장하는 문자들을 처리
            for (int j = 0; j < str.length(); j++) {
                if (alpha[str.charAt(j) - 'a'] < k) 
                    continue;

                int cnt = 1;
                for (int l = j + 1; l < str.length(); l++) {
                    // 문자가 일치하면 카운트 증가
                    if (str.charAt(j) == str.charAt(l)) cnt++;
                    
                    // 최대, 최소 갱신
                    if (cnt == k) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == -1) {
                System.out.println("-1");
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}
