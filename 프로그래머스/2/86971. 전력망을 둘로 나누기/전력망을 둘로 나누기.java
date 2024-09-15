import java.util.*;

class Solution {
    boolean[] visited;
    List<Integer>[] adjList;
    int answer;
    int n;
    
    public int solution(int n, int[][] wires) {
        // 인접 리스트로 트리 구현
        // dfs로 각 자식 노드 개수 구하기
        
        // 1 : 3
        // 2 : 3
        // 3 : 1, 2, 4
        // 4 : 3, 5, 6, 7
        // 5 : 4
        // 6 : 4
        // 7 : 4, 8, 9
        // 8 : 7
        // 9 : 7        
        
        // 인접 리스트
        adjList = new ArrayList[n+1];
        for(int i=1; i<=n; i++) adjList[i] = new ArrayList<>();
        for(int[] wire : wires) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }
        
        // 각 간선을 제거한 후 bfs로 노드 개수 구하기
        answer = n-1;
        this.n = n;
        visited = new boolean[n+1];
        dfs(1);
        
        return answer;
    }
    
    public int dfs(int now) {
        visited[now] = true;
        int sum = 0;
        
        for(int next : adjList[now]) {
            if(!visited[next]) {
                int cnt = dfs(next);
                sum += cnt;
                answer = Math.min(answer, Math.abs(n-cnt*2));
            }
        }

        return sum + 1;
    }
}