package programmers;
import java.util.*;

// 재귀 함수 이용
// 참고 사이트 : https://ksb-dev.tistory.com/271
class Level2_N_Queen {
    int answer = 0;
    int[] visited;
    public int solution(int n) {
        visited = new int[n];

        // 같은 열이면 안됨
        // 대각선 겹치면 안됨

        dfs(n, 0);

        return answer;
    }

    // depth : 시작하는 행의 위치
    // n : 크기
    public void dfs(int n, int depth) {
        if(n == depth) {
            answer++;
            return ;
        }

        for(int i=0; i<n; i++) {
            visited[depth] = i;
            if(valid(depth)) {
                dfs(n, depth+1);
            }
        }
    }

    // 대각선 겹치는지 확인
    // visited : 퀸의 열 위치, n : 지금 열의 위치, check : 지금 퀸을 놓은 행의 위치
    public boolean valid(int depth) {
        for(int i=0; i<depth; i++) {
            if(visited[depth] == visited[i]) return false; // 같은 열에 있는 경우
            if(Math.abs(depth-i) == Math.abs(visited[depth]-visited[i])) return false; // 대각선에 있는 경우
        }
        return true;
    }
}