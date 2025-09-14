class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 1) checkSafeArea(board, i, j);
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
    
    public void checkSafeArea(int[][] board, int y, int x) {
        for(int i=Math.max(y-1, 0); i<=Math.min(y+1, board.length-1); i++) {
            for(int j=Math.max(x-1, 0); j<=Math.min(x+1, board[i].length-1); j++) {
                if(board[i][j] == 0) board[i][j] = -1;
            }
        }
    }
}