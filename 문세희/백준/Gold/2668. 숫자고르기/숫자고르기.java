import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] secondRow = new int[n + 1]; // 1-indexed로 사용
        
        for (int i = 1; i <= n; i++) {
            secondRow[i] = scanner.nextInt();
        }
        
        boolean[] visited = new boolean[n + 1];
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                // 각 연결 요소를 독립적으로 처리
                List<Integer> component = new ArrayList<>();
                findCycles(i, secondRow, visited, component);
                
                // 연결 요소에서 조건을 만족하는 최대 부분집합 찾기
                List<Integer> validSubset = findMaxValidSubset(component, secondRow);
                result.addAll(validSubset);
            }
        }
        
        // 결과 정렬
        Collections.sort(result);
        
        // 출력
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
        
        scanner.close();
    }
    
    // DFS로 연결 요소 찾기
    private static void findCycles(int start, int[] secondRow, boolean[] visited, List<Integer> component) {
        int current = start;
        
        while (!visited[current]) {
            visited[current] = true;
            component.add(current);
            current = secondRow[current];
        }
        
        // 이미 방문한 노드이지만 현재 연결 요소에 포함되어 있지 않다면 추가하지 않음
        if (!component.contains(current)) {
            return;
        }
        
        // current가 사이클의 시작 노드
        int cycleStart = current;
        
        // 사이클에 포함되지 않은 노드들 제거 (선택적)
        // 이 문제에서는 사이클에 포함되지 않은 노드도 조건을 만족할 수 있으므로 제거하지 않음
    }
    
    // 연결 요소에서 조건을 만족하는 최대 부분집합 찾기
    private static List<Integer> findMaxValidSubset(List<Integer> component, int[] secondRow) {
        int n = component.size();
        if (n == 0) return new ArrayList<>();
        
        // 가능한 모든 부분집합을 검사
        List<Integer> maxSubset = new ArrayList<>();
        
        for (int mask = 1; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            Set<Integer> subsetValues = new HashSet<>();
            
            // 현재 부분집합 구성
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(component.get(i));
                    subsetValues.add(component.get(i));
                }
            }
            
            // 조건 검사: 부분집합의 각 원소 x에 대해, f(x)도 부분집합에 포함되어야 함
            boolean isValid = true;
            Set<Integer> secondRowValues = new HashSet<>();
            
            for (int x : subset) {
                int fx = secondRow[x];
                secondRowValues.add(fx);
                
                if (!subsetValues.contains(fx)) {
                    isValid = false;
                    break;
                }
            }
            
            // 추가 조건: f(S) = S 확인 (두 집합의 크기와 내용이 같아야 함)
            if (isValid && secondRowValues.size() == subset.size() && 
                subsetValues.containsAll(secondRowValues)) {
                
                // 최대 부분집합 갱신
                if (subset.size() > maxSubset.size()) {
                    maxSubset = new ArrayList<>(subset);
                }
            }
        }
        
        return maxSubset;
    }
}