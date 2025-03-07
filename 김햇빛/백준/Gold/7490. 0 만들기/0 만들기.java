import java.util.*;

public class Main {
    
    public static int calculateExpression(String expr) {
        // 공백을 제거하고 수식 계산
        expr = expr.replaceAll(" ", "");
        
        int result = 0;
        int num = 0;
        char operator = '+';
        
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            
            // 연산자이거나 마지막 숫자가 끝났을 때
            if (i == expr.length() - 1 || !Character.isDigit(ch)) {
                if (operator == '+') {
                    result += num;
                } else if (operator == '-') {
                    result -= num;
                }
                
                // 새로운 연산자 처리
                if (ch == '+' || ch == '-') {
                    operator = ch;
                }
                
                num = 0;
            }
        }
        
        return result;
    }
    
    public static void backtrack(String current, int index, int N, List<String> result) {
        if (index == N) {
            // 수식의 결과가 0이면 결과에 추가
            if (calculateExpression(current) == 0) {
                result.add(current);
            }
            return;
        }

        if (index > 0) {
            backtrack(current + "+" + (index + 1), index + 1, N, result);
            backtrack(current + "-" + (index + 1), index + 1, N, result);
            backtrack(current + " " + (index + 1), index + 1, N, result);
        } else {
            // 첫 번째 숫자는 그냥 추가
            backtrack((index + 1) + "", index + 1, N, result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        sc.nextLine();
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            sc.nextLine();  // 개행 문자 처리
            
            List<String> result = new ArrayList<>();

            backtrack("1", 1, N, result);
            
            // 결과를 알파벳 순으로 정렬
            Collections.sort(result);
            
            for (String expr : result) {
                System.out.println(expr);
            }
            if (t < T - 1) {
                System.out.println();
            }
        }
        
    }
}
