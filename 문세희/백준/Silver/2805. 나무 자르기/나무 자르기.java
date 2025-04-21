import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] trees; // 각 나무의 길이를 담는 배열
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 나무의 수
        // 집으로 가져가려는 나무의 길이
        // 모든 나무의 길이는 m보다 크다
        // 그럼 첫 기준을 m으로 잡으면 되지 않나?
        // 최소 1 최대 m
        // 높이가 나무 길이 - m
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        M = Integer.parseInt(st.nextToken()); // 필요한 나무 길이
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0; // 가장 큰 나무 길이에 맞추기
        // 만약 가장 큰 나무가 m보다 작으면 가장 큰 나무 길이에 맞추고 아니면 나무길이 - m
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        // 가장 높은 나무가 m보다 크면 높이 - m, 아니면 0으로 시작
        int height = Math.max(max - M, 0);

        int answer = binarySearch(height, max);

        System.out.println(answer);

    }

    static int binarySearch(int left, int right) {
        int result = 0; 
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0; // 자른 나무 길이의 합계
            for (int tree : trees) {
                // 지금 주어진건 절단기 높이임
                // 나무 높이가 절단기보다 낮거나 같으면 잘리는 부분이 없음
                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            // 자른 나무의 길이의 총합이 필요한 거 이상이면 높이를 높히면 됨
            if (sum >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}