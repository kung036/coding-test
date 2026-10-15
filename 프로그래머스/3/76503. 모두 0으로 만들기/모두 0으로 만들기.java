import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        int n = a.length;

        long[] w = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            w[i] = a[i];
            sum += a[i];
        }
        if (sum != 0) return -1;

        // 인접 리스트 (배열 기반)
        int[] head = new int[n];
        int[] next = new int[(n - 1) * 2];
        int[] to = new int[(n - 1) * 2];
        Arrays.fill(head, -1);
        int cnt = 0;
        for (int[] e : edges) {
            to[cnt] = e[1]; next[cnt] = head[e[0]]; head[e[0]] = cnt++;
            to[cnt] = e[0]; next[cnt] = head[e[1]]; head[e[1]] = cnt++;
        }

        // 0번을 루트로 BFS해서 방문 순서와 부모 기록 (재귀 대신 반복문)
        int[] order = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[n];
        int front = 0, back = 0;
        order[back++] = 0;
        visited[0] = true;
        while (front < back) {
            int cur = order[front++];
            for (int i = head[cur]; i != -1; i = next[i]) {
                int nxt = to[i];
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    parent[nxt] = cur;
                    order[back++] = nxt;
                }
            }
        }

        // 리프부터 거꾸로 올라오면서 서브트리 합을 부모에게 넘김
        long answer = 0;
        for (int i = n - 1; i > 0; i--) {
            int v = order[i];
            answer += Math.abs(w[v]);
            w[parent[v]] += w[v];
        }
        return answer;
    }
}