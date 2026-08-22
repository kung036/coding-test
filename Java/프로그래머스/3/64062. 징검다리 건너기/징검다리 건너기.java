class Solution {
    public int solution(int[] stones, int k) {
        int lo = 1, hi = 200_000_000, answer = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canCross(stones, k, mid)) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return answer;
    }

    // x명이 모두 건널 수 있는지 판별
    private boolean canCross(int[] stones, int k, int x) {
        int count = 0; // x보다 작은 값이 연속되는 길이
        for (int stone : stones) {
            if (stone < x) {
                count++;
                if (count >= k) return false; // k개 이상 연속되면 x번째 사람은 막힘
            } else {
                count = 0;
            }
        }
        return true;
    }
}