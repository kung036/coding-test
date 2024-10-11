import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // m : 가로, n : 세로, puddles : 물에 잠김 위치
        // 가장 왼쪽 위 : 집, 가장 오른쪽 아래 : 학교
        // 집 -> 학교(물웅덩이 위치 피해서 가는 최단 경로의 개수)
        // puddle = (가로, 세로)
        
        // 1 + 1 + (1+1) + (3+3) = 2+2+6 = 10
        // 0 1 1 1
        // 1 -1 1 2 
        // 1 1 2 4 

        // 0 1 1 1
        // 1 2 3 4
        // 1 3 6 10
        int[][] visited = new int[n+1][m+1];
        int mod = 1_000_000_007;
        
        for(int[] puddle : puddles) {
            visited[puddle[1]][puddle[0]] = -1;
        }
        
        visited[1][1] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(visited[i][j] == -1) visited[i][j] = 0;
                else {
                    if(i>1) visited[i][j] += visited[i-1][j];
                    if(j>1) visited[i][j] += visited[i][j-1];
                    visited[i][j] %= mod;
                }
            }
        }
        
        return visited[n][m];
    }
}