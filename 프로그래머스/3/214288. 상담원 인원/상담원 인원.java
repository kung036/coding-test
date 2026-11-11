import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        // 유형별 요청 분리 (reqs는 요청 시각 오름차순으로 주어짐)
        List<List<int[]>> byType = new ArrayList<>();
        for (int i = 0; i <= k; i++) byType.add(new ArrayList<>());
        for (int[] r : reqs) byType.get(r[2]).add(r);

        int maxM = n - k + 1; // 한 유형에 배치 가능한 최대 멘토 수

        // wait[t][m] = 유형 t에 멘토 m명일 때 총 대기 시간
        int[][] wait = new int[k + 1][maxM + 1];
        for (int t = 1; t <= k; t++) {
            for (int m = 1; m <= maxM; m++) {
                wait[t][m] = simulate(byType.get(t), m);
            }
        }

        // dp[i][j] = 유형 1~i에 멘토 j명을 배분했을 때 최소 대기 시간
        final int INF = Integer.MAX_VALUE;
        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0;

        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                for (int m = 1; m <= Math.min(maxM, j - (i - 1)); m++) {
                    if (dp[i - 1][j - m] == INF) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - m] + wait[i][m]);
                }
            }
        }
        return dp[k][n];
    }

    // 멘토 m명일 때 해당 유형 요청들의 총 대기 시간
    private int simulate(List<int[]> list, int m) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 멘토별 상담 종료 시각
        for (int i = 0; i < m; i++) pq.add(0);

        int total = 0;
        for (int[] r : list) {
            int end = pq.poll();               // 가장 빨리 끝나는 멘토
            int start = Math.max(end, r[0]);   // 실제 상담 시작 시각
            total += start - r[0];             // 대기 시간 누적
            pq.add(start + r[1]);              // 상담 종료 시각 갱신
        }
        return total;
    }
}