class Solution {
    public int solution(int[] a) {
        int n = a.length;

        int[] leftMin = new int[n];
        leftMin[0] = a[0];

        // 왼쪽에서 가장 작은 값 저장
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        int answer = 0;

        // 오른쪽에서 가장 작은 값
        int rightMin = a[n - 1];

        for (int i = n - 1; i >= 0; i--) {

            // 양 끝은 무조건 살아남을 수 있음
            if (i == 0 || i == n - 1) {
                answer++;
            }

            // 현재 풍선보다 작은 풍선이
            // 왼쪽 또는 오른쪽에 존재하면 살아남을 수 있음
            else if (a[i] < leftMin[i - 1] || a[i] < rightMin) {
                answer++;
            }

            rightMin = Math.min(rightMin, a[i]);
        }

        return answer;
    }
}