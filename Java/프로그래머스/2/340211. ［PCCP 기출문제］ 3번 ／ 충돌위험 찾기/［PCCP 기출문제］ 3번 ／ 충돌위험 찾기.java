import java.util.*;

public class Solution {
    public int solution(int[][] points, int[][] routes) {
        int x = routes.length;
        List<List<int[]>> allPositions = new ArrayList<>();

        for (int i = 0; i < x; i++) {
            int[] route = routes[i];
            List<int[]> pos = new ArrayList<>();
            int[] start = points[route[0] - 1];
            int curR = start[0], curC = start[1];
            pos.add(new int[]{curR, curC}); // t=0

            for (int j = 1; j < route.length; j++) {
                int[] target = points[route[j] - 1];
                int dr = target[0] - curR;
                int dc = target[1] - curC;
                int stepR = Integer.signum(dr);
                int stepC = Integer.signum(dc);
                int nr = Math.abs(dr);
                int nc = Math.abs(dc);

                // r 방향 먼저 모두 이동
                for (int k = 0; k < nr; k++) {
                    curR += stepR;
                    pos.add(new int[]{curR, curC});
                }
                // 그 다음 c 방향 이동
                for (int k = 0; k < nc; k++) {
                    curC += stepC;
                    pos.add(new int[]{curR, curC});
                }
            }
            allPositions.add(pos);
        }

        Map<Long, Integer> countMap = new HashMap<>();
        for (List<int[]> pos : allPositions) {
            for (int t = 0; t < pos.size(); t++) {
                int r = pos.get(t)[0];
                int c = pos.get(t)[1];
                long coordCode = r * 101L + c;
                long key = (long) t * 100000L + coordCode;
                countMap.merge(key, 1, Integer::sum);
            }
        }

        int answer = 0;
        for (int v : countMap.values()) {
            if (v >= 2) answer++;
        }
        return answer;
    }
}