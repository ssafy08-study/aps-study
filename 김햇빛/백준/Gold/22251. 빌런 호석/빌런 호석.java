import java.util.Scanner;

public class Main {
    // 각 숫자에 대한 7-segment 디스플레이 비트마스크 (7개의 LED에 대한 상태)
    static final int[] segment = {
        0b1111110, // 0
        0b0110000, // 1
        0b1101101, // 2
        0b1111001, // 3
        0b0110011, // 4
        0b1011011, // 5
        0b1011111, // 6
        0b1110000, // 7
        0b1111111, // 8
        0b1111011  // 9
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 빌딩의 총 층 수
        int K = sc.nextInt();  // 디스플레이의 자리 수
        int P = sc.nextInt();  // 최대 반전할 수 있는 LED 수
        int X = sc.nextInt();  // 현재 층수

     // X층을 K자리로 맞추기
        String targetStr = String.format("%0" + K + "d", X);  // X층을 K자리로 변환

        int result = 0;

        // 1부터 N까지 모든 층을 확인
        for (int i = 1; i <= N; i++) {
            // i 층을 K자리로 맞추기
            String str = String.format("%0" + K + "d", i);  // i층을 K자리로 변환
            int count = 0;

            // 각 자리 수에 대해 LED 반전 수를 계산
            for (int j = 0; j < K; j++) {
                // 현재 층의 j번째 자리 수와 목표 층의 j번째 자리 수를 비교
                int digit1 = targetStr.charAt(j) - '0';
                int digit2 = str.charAt(j) - '0';

                // 두 숫자의 비트 차이로 반전된 LED 수 계산
                count += Integer.bitCount(segment[digit1] ^ segment[digit2]);
            }

            // 반전된 LED가 1개 이상 P개 이하인 경우
            if (count >= 1 && count <= P) {
                result++;
            }
        }

        System.out.println(result);
    }
}

