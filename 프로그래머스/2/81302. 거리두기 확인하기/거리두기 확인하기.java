class Solution {
    int[] dy = {0,0,-1,1};
    int[] dx = {1,-1,0,0};
    int n = 5;
    
    public int[] solution(String[][] places) {
        // P : 응시자, 0 : 빈 테이블, X : 파티션
        // 응시자 자리 3 이상으로 앉아야함
        //     0 
        //   0 0 0 
        // 0 0 0 0 0
        //   0 0 0 
        //     0 
        // 모든 P를 돌면서 2이내에 P가 있으면 0, 아니면 1 반환
        
        int[] answer = new int[n];
        char[][] place = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                place[j] = places[i][j].toCharArray();
            }
            answer[i] = find(place, 0, 1, 0, 0);
        }
        
        return answer;
    }
    
    public int find(char[][] place, int dp, int anw, int x, int y) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(place[i][j] == 'P') anw = dfs(place, 0, anw, j, i, j, i);
                if(anw == 0) break;
            }
            if(anw == 0) break;
        }
        
        return anw;
    }
    
    public int dfs(char[][] place, int dp, int anw, int x, int y, int curX, int curY) {
        // 거리두기를 지키지 않은 경우
        if(anw == 0) return 0;
        
        // 거리가 2를 넘은 경우
        if(dp == 2) return anw;
        
        for(int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 처음 위치인 경우
            if(nx == curX && ny == curY) continue;

            // 격자를 벗어난 경우
            if(nx<0 || ny<0 || n<=nx || n<=ny) continue;
            
            // 파티션(X)인 경우
            if(place[ny][nx] == 'X') continue;
            
            // P인 경우
            if(place[ny][nx] == 'P') return 0;

            anw = dfs(place, dp+1, anw, nx, ny, curX, curY);
        }
        
        return anw;
    }
}