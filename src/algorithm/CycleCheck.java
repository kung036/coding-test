package algorithm;

import java.util.Arrays;

public class CycleCheck {
    // 인접 행렬(가중치 포함)
    int[][] weight;

    // 부모 정점
    int[] parent;

    // 인접 행렬 만들기
    public void initialWeight(int[][] edges, int n) {
        weight = new int[n+1][n+1];

        for(int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            weight[edge[0]][edge[1]] = edge[2];
            weight[edge[1]][edge[0]] = edge[2];
        }
    }

    // 부모 정점 초기화
    public void initialParent(int n) {
        parent = new int[n+1];
        Arrays.fill(parent, -1); // -1로 초기화
    }

    // 두 정점이 같은 사이클에 있는지 확인
    public boolean union(int x, int y) {
        boolean cycle = true;
        int root1 = find(x); // x의 루트 정점
        int root2 = find(y); // y의 루트 정점

        if(root1 != root2) { // 다른 집합에 속해 있을 경우 -> 사이클 형성 X
            parent[root1] = root2; // x와 y 연결
            cycle = false;
        }

        return cycle; // 사이클 여부 반환(true : 사이클O, false : 사이클X)
    }

    // x가 속한 집합 반환(정점 반환)
    public int find(int x) {
        int cur = parent[x];
        if(cur == -1) return x;

        // 정점 x의 집합 구하기
        while(parent[cur] != -1) { // 최고 정점을 구할 때까지 반복
            cur = parent[cur]; // 상위 정점
        }

        return cur; // x가 속한 정점 반환
    }

    // 인접행렬을 이용해서 parent 행렬 구하기
    public void findParent() {
        for(int i=0; i<weight.length; i++) {
        }
    }

    // 두 정점 x, y가 사이클에 있는지 확인
    public boolean union_find(int[][] edges, int n, int x, int y) {
        // 초기화
        initialParent(n);
        initialWeight(edges, n);

        System.out.println(Arrays.toString(parent));

        return union(x, y);
    }
}