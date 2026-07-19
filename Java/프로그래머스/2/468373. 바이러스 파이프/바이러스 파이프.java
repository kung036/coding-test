import java.util.*;

class Solution {
    int n;
    List<List<Integer>>[] adj;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        adj = new List[4];
        for (int t = 1; t <= 3; t++) {
            adj[t] = new ArrayList<>();
            for (int i = 0; i <= n; i++) adj[t].add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int x = e[0], y = e[1], t = e[2];
            adj[t].get(x).add(y);
            adj[t].get(y).add(x);
        }

        boolean[] init = new boolean[n + 1];
        init[infection] = true;

        int[] best = {1}; // 아무 행동 안 해도 감염체 1개는 있음
        dfs(init, k, 0, best);

        return best[0];
    }

    void dfs(boolean[] infected, int remaining, int lastType, int[] best) {
        best[0] = Math.max(best[0], count(infected));
        if (remaining == 0) return;

        for (int t = 1; t <= 3; t++) {
            if (t == lastType) continue;
            boolean[] next = infected.clone();
            spread(next, t);
            dfs(next, remaining - 1, t, best);
        }
    }

    void spread(boolean[] infected, int type) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) if (infected[i]) q.add(i);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : adj[type].get(cur)) {
                if (!infected[nxt]) {
                    infected[nxt] = true;
                    q.add(nxt);
                }
            }
        }
    }

    int count(boolean[] infected) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) if (infected[i]) cnt++;
        return cnt;
    }
}