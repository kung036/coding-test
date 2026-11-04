import java.util.*;

class Solution {
    int[] parent;

    int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    void union(int a, int b) {
        a = find(a); b = find(b);
        if (a != b) parent[a] = b;
    }

    public int[] solution(int[] nodes, int[][] edges) {
        int n = nodes.length;
        int[] idx = new int[1_000_001];      // 노드 번호 -> 인덱스
        for (int i = 0; i < n; i++) idx[nodes[i]] = i;

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int[] deg = new int[n];

        for (int[] e : edges) {
            int a = idx[e[0]], b = idx[e[1]];
            deg[a]++; deg[b]++;
            union(a, b);
        }

        int[] cntA = new int[n];   // 루트일 때 홀짝 노드가 되는 노드 수
        int[] cntB = new int[n];   // 루트일 때 역홀짝 노드가 되는 노드 수
        for (int i = 0; i < n; i++) {
            int r = find(i);
            if (nodes[i] % 2 == deg[i] % 2) cntA[r]++;
            else cntB[r]++;
        }

        int oddEven = 0, reverse = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) != i) continue;      // 트리 대표만 확인
            if (cntA[i] == 1) oddEven++;
            if (cntB[i] == 1) reverse++;
        }
        return new int[]{oddEven, reverse};
    }
}