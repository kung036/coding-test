class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left) + 1;
        int[] answer = new int[len];

        for (int k = 0; k < len; k++) {
            long pos = left + k;
            int row = (int)(pos / n);  // 행 (0-indexed)
            int col = (int)(pos % n);  // 열 (0-indexed)
            answer[k] = Math.max(row, col) + 1;
        }

        return answer;
    }
}