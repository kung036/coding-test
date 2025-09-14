class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        // 지뢰 주변의 안전하지 않은 지역의 값을 -1로 변경
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 1) checkSafeArea(board, i, j);
            }
        }
        
        // 안전한 지역(0) 개수 카운팅
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
    
    // 지뢰 주변 지역을 -1로 변경하는 함수
    public void checkSafeArea(int[][] board, int y, int x) {
        // 시작 지점은 0 이상, 마지막 지점은 board의 길이 아래로 설정해서 board의 범위를 벗어나지 않도록 변경
        for(int i=Math.max(y-1, 0); i<=Math.min(y+1, board.length-1); i++) {
            for(int j=Math.max(x-1, 0); j<=Math.min(x+1, board[i].length-1); j++) {
                if(board[i][j] == 0) board[i][j] = -1;
            }
        }
    }
}