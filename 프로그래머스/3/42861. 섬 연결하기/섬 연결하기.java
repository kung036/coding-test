import java.util.*;

class Solution {
    public int[] parent;
    
    public int find(int node) {
        if(parent[node] == node) return node;
        
        return parent[node] = find(parent[node]);
    }
    
    public void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        parent[parentA] = parentB;
    }
    
    public int solution(int n, int[][] costs) {
        // 최소신장트리 알고리즘 - 사이클이 형성되지 않은 최소 비용으로 형성된 트리를 구하는 알고리즘
        
        // 트리
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        // costs 비용을 오른차순으로 정렬
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        // 간선 선택
        int edge = 0; // 최소신장트리 간선 개수
        int answer = 0;
        for(int[] cost : costs) {
            if(edge == n-1) break;
            
            // 선택할 경우 사이클이 선택되는지 확인
            if(find(cost[0]) != find(cost[1])) {
                answer += cost[2];
                edge++;
                union(cost[0], cost[1]);
            }
        }
        
        
        return answer;
    }
}