import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int totalA = 0;
        for (int[] it : info) totalA += it[0];

        int capacity = m - 1; // B가 채울 수 있는 최대 흔적
        int[] dp = new int[capacity + 1];

        for (int[] it : info) {
            int w = it[1]; // B 흔적 (무게)
            int v = it[0]; // A 흔적 (가치, B가 대신 훔쳐서 아끼는 양)
            for (int c = capacity; c >= w; c--) {
                dp[c] = Math.max(dp[c], dp[c - w] + v);
            }
        }

        int answer = totalA - dp[capacity];
        return answer < n ? answer : -1;
    }
}