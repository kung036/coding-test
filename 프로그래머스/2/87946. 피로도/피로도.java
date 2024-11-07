import java.util.*;

class Solution {
    int max = 0;
    int[][] dungeons;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        // 최소 필요 피로도를 내림차순으로 정렬
        Arrays.sort(dungeons, (o1, o2) -> Integer.compare(o2[0], o1[0]));
    
        // dfs 전체 탐색
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        dfs(k, 0);
        
        return max;
    }
    
    public void dfs(int k, int cnt) {
        max = Math.max(max, cnt);
        if(max == dungeons.length) return;
        
        for(int i=0; i<dungeons.length; i++) {
            if(visited[i]) continue;
            
            if(dungeons[i][0] <= k) { // 방문 가능한 던전
                visited[i] = true;
                dfs(k-dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
    
}