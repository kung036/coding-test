class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int h = schedules[i] / 100;
            int m = schedules[i] % 100 + 10;
            if (m >= 60) { m -= 60; h += 1; }
            int deadline = h * 100 + m;

            boolean ok = true;
            for (int j = 0; j < 7; j++) {
                int day = (startday - 1 + j) % 7 + 1;
                if (day == 6 || day == 7) continue; // 토,일 제외
                if (timelogs[i][j] > deadline) {
                    ok = false;
                    break;
                }
            }
            if (ok) answer++;
        }
        return answer;
    }
}