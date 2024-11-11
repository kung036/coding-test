import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 모든 경로들의 최단 경로 계산하기(플로드-워셜)
        int[][] graph = new int[n][n];
        int INF = Integer.MAX_VALUE;
        for(int[] fare : fares) {
            int n1 = fare[0]-1;
            int n2 = fare[1]-1;
            graph[n1][n2] = fare[2];
            graph[n2][n1] = fare[2];
        }
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(i == j) continue;
                    if(graph[i][k]!=0 && graph[k][j]!=0) { // 길이 있는 경우
                        if(graph[i][j] == 0) graph[i][j] = graph[i][k]+graph[k][j];
                        else graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                    }
                }
            }
        }

        // 둘 중 최소값 선택하기
        // 따로 귀가 : (S->A) + (S->B)
        // 택시 합승 : (S->X) + (X->A) + (X->B)        
        s--;
        a--;
        b--;
        int answer = graph[s][a]+graph[s][b]; // 따로 귀가하는 경우
        for(int i=0; i<n; i++) {
            if(graph[s][i] == 0) continue; // 서로 연결되어 있지 않은 경우
            int taxi = graph[s][i]+graph[i][a]+graph[i][b];
            answer = Math.min(answer, taxi);
        }
        return answer;
    }
}