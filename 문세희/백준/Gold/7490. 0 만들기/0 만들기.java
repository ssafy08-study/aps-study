import java.io.*;
import java.util.*;

public class Main {
    static List<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        
        for (int t = 0; t < testCases; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            
            result = new ArrayList<>();
            String[] ops = new String[N-1];
            
            generateExpressions(ops, 0, N);
            
            for (String expr : result) {
                System.out.println(expr);
            }
            
            if (t < testCases - 1) {
                System.out.println();
            }
        }
    }
    
    static void generateExpressions(String[] ops, int idx, int N) {
        if (idx == N-1) {
            String expr = buildExpression(ops, N);
            if (evaluate(expr) == 0) {
                result.add(expr);
            }
            return;
        }
        
        ops[idx] = " ";
        generateExpressions(ops, idx + 1, N);
        
        ops[idx] = "+";
        generateExpressions(ops, idx + 1, N);
        
        ops[idx] = "-";
        generateExpressions(ops, idx + 1, N);
    }
    
    static String buildExpression(String[] ops, int N) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        
        for (int i = 0; i < N-1; i++) {
            sb.append(ops[i]).append(i + 2);
        }
        
        return sb.toString();
    }
    
    static long evaluate(String expr) {
        // 수식의 각 항목을 저장
        List<String> tokens = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        
        // 수식을 토큰화
        StringTokenizer st = new StringTokenizer(expr, "+-", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("+") || token.equals("-")) {
                operators.add(token);
            } else {
                tokens.add(token.replaceAll(" ", ""));
            }
        }
        
        // 계산
        long result = Long.parseLong(tokens.get(0));
        for (int i = 0; i < operators.size(); i++) {
            long num = Long.parseLong(tokens.get(i + 1));
            if (operators.get(i).equals("+")) {
                result += num;
            } else {
                result -= num;
            }
        }
        
        return result;
    }
}