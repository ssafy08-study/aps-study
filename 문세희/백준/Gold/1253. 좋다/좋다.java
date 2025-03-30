import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        int sum = 0;
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            long find = arr[i];
            int start = 0;
            int end = N - 1;
            while (start < end) {
                if (find > arr[start] + arr[end]) {
                    start++;
                } else if (find < arr[start] + arr[end]) {
                    end--;
                } else {
                    if (i != start && i != end) {
                        count++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                }
            }
        }

        System.out.println(count);

    }
}

