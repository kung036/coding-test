import java.util.*;

class Solution {
    boolean[] check;
    int[] queenIndex;
    int answer = 0;
    
    public int solution(int n) {
        // dfs로 퀸의 위치 구하기
        // 열의 index에 퀸의 방문 여부
        // 각 행의 퀸의 index가 저장되어 배열
        
        check = new boolean[n];
        queenIndex = new int[n];
        Arrays.fill(queenIndex, -1);
        dfs(0, n);
        
        return answer;
    }
    
    // n : 체스판 길이, index : 현재 행의 위치
    public void dfs(int index, int n) {
        boolean[] possible = new boolean[n]; // 방문 가능한 곳
        for(int i=0; i<n; i++) {
            if(queenIndex[i] == -1) break;
            possible[queenIndex[i]] = true;
            int dx = index - i;
            if(0 <= queenIndex[i]-dx) possible[queenIndex[i]-dx] = true;
            if(queenIndex[i]+dx < n) possible[queenIndex[i]+dx] = true;
        }
        
        for(int i=0; i<n; i++) {
            // if(check[i]) continue; // 이미 방문한 열인 경우
            if(possible[i]) continue; // 방문 불가능한 경우
            if(index == n-1) {
                answer++;
                continue;
            }
            queenIndex[index] = i;
            dfs(index+1, n);
            queenIndex[index] = -1;
        }
    }
}