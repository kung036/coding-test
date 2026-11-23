import java.util.*;

class Solution {
    Map<Long, Integer> memo = new HashMap<>();

    public int solution(int n) {
        memo.clear();
        return dfs(n, 0);
    }

    // v: 현재 음높이, e: 지금까지 뒤에서 뗀 '+' 개수 - 2 * (뗀 '*' 개수)
    int dfs(int v, int e) {
        if (v < 1) return 0;
        if (v == 1) return e == 0 ? 1 : 0;

        // 앞으로 나눌 수 있는 '*'는 최대 floor(log3 v)개 → e를 다 못 갚으면 가지치기
        int k = 0;
        for (int t = v; t >= 3; t /= 3) k++;
        if (e > 2 * k) return 0;

        long key = (long) v * 1000 + e;
        Integer cached = memo.get(key);
        if (cached != null) return cached;

        int res;
        if (v % 3 != 0) {
            res = dfs(v - v % 3, e + v % 3);       // 3의 배수가 될 때까지 '+'를 뗌
        } else {
            res = 0;
            if (e >= 2) res += dfs(v / 3, e - 2);   // '*' 떼기: 그 '*'가 쓸 '+' 2개를 갚음
            res += dfs(v - 3, e + 3);               // '+' 3개 더 떼기
        }
        memo.put(key, res);
        return res;
    }
}