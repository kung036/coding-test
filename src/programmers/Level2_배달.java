package programmers;

import java.util.*;


// 가중치 : 인접 행렬
// dijkstra 알고리즘

public class Level2_배달 {
    public int solution(int N, int[][] roads, int K) {
        int answer = 0;

        // 인접 행렬
        int[][] weight = new int[N + 1][N + 1];
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int c = road[2];

            if (weight[a][b] == 0 || weight[a][b] > c) {
                weight[a][b] = c;
                weight[b][a] = c;
            }
        }

        // 방문 여부
        boolean[] visited = new boolean[N + 1];
        visited[0] = true;

        // 거리
        int[] distance = new int[N + 1];

        int cur = 1; // 현재 방문한 정점
        // 1번마을로부터 떨어진 배달 시간 구하기
        while (!check(visited)) { // 모든 정점 방문하기
            // distance에 가중치 반영
            for (int i = 1; i <= N; i++) {
                if (i == cur) continue;
                if (!visited[i] && weight[cur][i] != 0) {
                    if (distance[i] == 0) distance[i] = distance[cur] + weight[cur][i];
                    else if (distance[i] > distance[cur] + weight[cur][i])
                        distance[i] = distance[cur] + weight[cur][i];
                    // System.out.println("cur : " + cur + " distance : " + distance[i] + " weight : " + weight[cur][i]);
                }
            }

            // visited 방문하기
            visited[cur] = true;

            // 방문한 정점과 연결된 정점 중 방문 안하고 가장 거리가 적은 정점 선택하기
            int min = 500001;
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && distance[i] != 0 && distance[i] < min) {
                    cur = i;
                    min = distance[cur];
                }
            }
            // System.out.println(Arrays.toString(distance));
        }

        // K 이하인 곳이 몇 개인지 확인하기
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) answer++;
        }
        // System.out.println(Arrays.toString(distance));

        return answer;
    }

    // 모든 정점 방문 : true
    public boolean check(boolean[] visited) {
        for (boolean b : visited) {
            if (!b) return false;
        }

        return true;
    }
}