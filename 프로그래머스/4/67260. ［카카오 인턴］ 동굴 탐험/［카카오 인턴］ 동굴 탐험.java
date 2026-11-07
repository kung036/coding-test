import java.util.*;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] p : path) {
            adj[p[0]].add(p[1]);
            adj[p[1]].add(p[0]);
        }

        int[] before = new int[n];   // before[B] = A : A를 먼저 방문해야 B 방문 가능
        int[] wait = new int[n];     // wait[A] = B : A 방문을 기다리는 방 B
        Arrays.fill(before, -1);
        Arrays.fill(wait, -1);
        for (int[] o : order) before[o[1]] = o[0];

        if (before[0] != -1) return false;   // 0번 방보다 먼저 가야 하는 방이 있으면 불가

        boolean[] visited = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;

            // cur을 기다리던 방이 있으면 이제 방문 가능
            if (wait[cur] != -1) {
                int w = wait[cur];
                visited[w] = true;
                q.add(w);
            }

            for (int nxt : adj[cur]) {
                if (visited[nxt]) continue;
                int pre = before[nxt];
                if (pre != -1 && !visited[pre]) {
                    wait[pre] = nxt;         // 선행 방을 아직 방문 안 함 → 보류
                    continue;
                }
                visited[nxt] = true;
                q.add(nxt);
            }
        }
        return count == n;
    }
}