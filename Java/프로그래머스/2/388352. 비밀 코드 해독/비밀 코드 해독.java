import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int count = 0;
        
        // 1~n 중 5개를 고르는 모든 조합 생성
        int[] combo = new int[5];
        count = dfs(1, 0, combo, n, q, ans);
        
        return count;
    }
    
    private int dfs(int start, int depth, int[] combo, int n, int[][] q, int[] ans) {
        if (depth == 5) {
            return isValid(combo, q, ans) ? 1 : 0;
        }
        
        int count = 0;
        for (int i = start; i <= n - (4 - depth); i++) {
            combo[depth] = i;
            count += dfs(i + 1, depth + 1, combo, n, q, ans);
        }
        return count;
    }
    
    private boolean isValid(int[] combo, int[][] q, int[] ans) {
        Set<Integer> codeSet = new HashSet<>();
        for (int num : combo) codeSet.add(num);
        
        for (int i = 0; i < q.length; i++) {
            int match = 0;
            for (int num : q[i]) {
                if (codeSet.contains(num)) match++;
            }
            if (match != ans[i]) return false;
        }
        return true;
    }
}