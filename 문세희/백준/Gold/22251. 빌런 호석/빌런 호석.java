import java.io.*;
import java.util.*;

public class Main {
    // 0~9까지 각 숫자의 7-세그먼트 LED 패턴
    private static final int[] SEGMENTS = {
        0b1111110, // 0
        0b0110000, // 1
        0b1011011, // 2
        0b1111001, // 3
        0b0110101, // 4
        0b1101101, // 5
        0b1101111, // 6
        0b1110000, // 7
        0b1111111, // 8
        0b1111101  // 9
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 최대 층수
        int K = Integer.parseInt(st.nextToken()); // 디스플레이 자릿수
        int P = Integer.parseInt(st.nextToken()); // 최대 반전 가능 횟수
        int X = Integer.parseInt(st.nextToken()); // 현재 층수
        
        // 각 숫자 간 LED 반전 횟수 미리 계산
        int[][] flipCount = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                flipCount[i][j] = Integer.bitCount(SEGMENTS[i] ^ SEGMENTS[j]);
            }
        }
        
        // 현재 층의 각 자릿수 배열
        int[] currentDigits = new int[K];
        int temp = X;
        for (int i = K - 1; i >= 0; i--) {
            currentDigits[i] = temp % 10;
            temp /= 10;
        }
        
        int answer = 0;
        
        // 모든 가능한 층 번호에 대해 검사
        for (int floor = 1; floor <= N; floor++) {
            if (floor == X) continue; // 현재 층은 건너뛰기
            
            // 각 자릿수 분리
            int[] digits = new int[K];
            temp = floor;
            for (int i = K - 1; i >= 0; i--) {
                digits[i] = temp % 10;
                temp /= 10;
            }
            
            // 필요한 LED 반전 횟수 계산
            int flips = 0;
            for (int i = 0; i < K; i++) {
                flips += flipCount[currentDigits[i]][digits[i]];
            }
            
            // 조건 확인: 1 이상 P 이하의 반전 필요
            if (1 <= flips && flips <= P) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}