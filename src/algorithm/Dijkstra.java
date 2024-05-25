package algorithm;

import java.util.*;

public class Dijkstra {
    // 방문 여부
    boolean[] visited;

    // 가중치
    int[][] weight;

    // 기준 정점 사이에 대한 정보
    class Road {
        int distance; // 가중치 합
        List<Integer> vertexes = new ArrayList<>(); // 연결된 정점들
    }

    //

    // 인접 행렬 만들기
    public void initialWeight(int[][] edges, int n) {
        weight = new int[n+1][n+1];

        for(int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            weight[edge[0]][edge[1]] = edge[2];
            weight[edge[1]][edge[0]] = edge[2];
        }
    }


}
