import java.util.*;

class Solution {
    public int solution(int[] arrows) {
        Set<String> e = new HashSet<>(); // 선
        Set<String> v = new HashSet<>(); // 점
        v.add("0,0");
                
        // 1~7까지의 좌표 이동 경로
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        int answer = 0;
        
        int x = 0;
        int y = 0;
        for(int a : arrows) {
            for(int i=0; i<2; i++) { // 대각선 점 때문에 2번 반복
                int nx = x + dx[a];
                int ny = y + dy[a];
                
                String currentV = x+","+y;
                String nextV = nx+","+ny;
                String e1 = currentV+"->"+nextV; 
                String e2 = nextV+"->"+currentV; // 반대방향(양방향이기 때문)
                
                // 점을 다른 방향에서 다시 방문하는 경우
                if(v.contains(nextV) && !e.contains(e1)) {
                    answer++;
                }
                
                v.add(nextV);
                e.add(e1);
                e.add(e2);
                
                x = nx;
                y = ny;
            }
        }

        return answer;
    }
}