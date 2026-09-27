class Solution {
    public long solution(int n) {
        long catalan = 1;
        for (int i = 1; i <= n; i++) {
            catalan = catalan * 2 * (2 * i - 1) / (i + 1);
        }
        return catalan;
    }
}