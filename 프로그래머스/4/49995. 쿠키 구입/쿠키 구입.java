class Solution {
    public int solution(int[] cookie) {
        int n = cookie.length;
        int answer = 0;

        // m: 분할 기준점 (첫째 구간 끝 = m, 둘째 구간 시작 = m+1)
        for (int m = 0; m < n - 1; m++) {
            int l = m, r = m + 1;
            long leftSum = cookie[l];
            long rightSum = cookie[r];

            while (l >= 0 && r < n) {
                if (leftSum == rightSum) {
                    answer = Math.max(answer, (int) leftSum);
                    l--;
                    if (l < 0) break;
                    leftSum += cookie[l];
                } else if (leftSum < rightSum) {
                    l--;
                    if (l < 0) break;
                    leftSum += cookie[l];
                } else { // leftSum > rightSum
                    r++;
                    if (r >= n) break;
                    rightSum += cookie[r];
                }
            }
        }

        return answer;
    }
}