class Solution {
    public int solution(int [][]board) {
        // 모든 칸을 돌면서 0이면 계속 탐색
        // 왼쪽 위, 위, 왼쪽 위치가 0이 아닌 경우 -> 최솟값 + 1
        
        int answer = 0;
        int h = board.length; // 세로
        int w = board[0].length; // 가로

        for(int i=1; i<h; i++) {
            for(int j=1; j<w; j++) {
                if(board[i][j]==0 || board[i-1][j-1]==0 || board[i-1][j]==0 || board[i][j-1]==0) continue;
                
                board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
                
                if(board[i][j] > answer) answer = board[i][j];
            }
        }
        
        if(answer == 0) {
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(board[i][j]==1) answer = 1;
                    if(answer != 0) break;
                }
                if(answer != 0) break;
            }
        }
        
        return answer*answer;
    }
}