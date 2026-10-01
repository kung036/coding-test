import java.util.*;

class Solution {
    int answer;

    public int solution(int n, int[] weak, int[] dist) {
        int len = weak.length;

        // 원형을 일자로 펴기: 취약 지점을 2배로 늘려둠
        int[] w = new int[len * 2];
        for (int i = 0; i < len; i++) {
            w[i] = weak[i];
            w[i + len] = weak[i] + n;
        }

        answer = dist.length + 1;
        permute(dist, new boolean[dist.length], new int[dist.length], 0, w, len);

        return answer > dist.length ? -1 : answer;
    }

    // 친구 투입 순서 전체 순열
    private void permute(int[] dist, boolean[] used, int[] order, int depth, int[] w, int len) {
        if (depth == dist.length) {
            check(order, w, len);
            return;
        }
        for (int i = 0; i < dist.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            order[depth] = dist[i];
            permute(dist, used, order, depth + 1, w, len);
            used[i] = false;
        }
    }

    // 모든 시작점에 대해 그리디로 커버
    private void check(int[] order, int[] w, int len) {
        for (int start = 0; start < len; start++) {
            int cnt = 1;
            int pos = w[start] + order[0]; // 첫 친구가 커버하는 끝 위치

            for (int i = start; i < start + len; i++) {
                if (w[i] > pos) {
                    cnt++;
                    if (cnt > order.length) break;
                    pos = w[i] + order[cnt - 1];
                }
            }

            if (cnt <= order.length) answer = Math.min(answer, cnt);
        }
    }
}