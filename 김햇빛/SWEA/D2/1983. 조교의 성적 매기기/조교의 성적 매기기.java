import java.util.*;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
             
            int[][] students = new int[N][2];
             
            for (int i = 0; i < N; i++) {
                int midterm = sc.nextInt();
                int finalExam = sc.nextInt();
                int assignment = sc.nextInt();
                
                int totalScore = (int) Math.round(midterm * 0.35 + finalExam * 0.45 + assignment * 0.2);
                students[i][0] = totalScore; 
                students[i][1] = i + 1; 
            }
             
            Arrays.sort(students, (a, b) -> b[0] - a[0]);
             
            String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
            int gradeInterval = N / 10;
 
            String grade = "";
            for (int i = 0; i < N; i++) {
                if (students[i][1] == K) {
                    grade = grades[i / gradeInterval];
                    break;
                }
            }

            System.out.println("#" + t + " " + grade);
        }
    }
}