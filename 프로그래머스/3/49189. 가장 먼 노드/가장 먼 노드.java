import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        int answer = 0;
        
        // 인접행렬로 그래프 구현하기
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        // 1번 노드와 다른 노드들 사이의 거리 구하기
        int max = 0; // 가장 긴 노드의 거리
        int[] dist = new int[n+1]; // 노드들 사이의 거리
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            int d = dist[node];
            for(int next : graph[node]) {
                if(dist[next] == 0 && next != 1) { // 방문하지 않은 경우
                    queue.add(next);
                    dist[next] = d+1;
                    max = Math.max(max, d+1);
                }
            }
        }
        
        final int finalMax = max;
        answer = (int) Arrays.stream(dist).filter(d -> d==finalMax).count();
        
        return answer;
    }
}