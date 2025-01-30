import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        arr[0] = N;
        for (int i = 1; i < N; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]);
            if (i < N - 1) {
                System.out.print(" ");
            }
        }
    }
}