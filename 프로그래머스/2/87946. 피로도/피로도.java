import java.util.*;

class Solution {
    int answer = 0;
    int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        // dungeons 오름차순 정렬해서 dfs 탐색하기
        Arrays.sort(dungeons, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        this.dungeons = dungeons;
        dfs(new boolean[dungeons.length], k, 0);
        
        return answer;
    }
    
    public void dfs(boolean[] visited, int remain, int cnt) {
        for(int i=0; i<dungeons.length; i++) {
            if(visited[i]) continue;
            if(dungeons[i][0] <= remain) {
                visited[i] = true;
                dfs(visited, remain-dungeons[i][1], cnt+1);
                visited[i] = false;
            } else break; // 남아있는 피로도가 적은 경우
        }
        
        answer = Math.max(cnt, answer);
    }
}