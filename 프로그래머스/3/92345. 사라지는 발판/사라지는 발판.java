import java.util.*;

class Solution {
    int Y; // 세로 길이
    int X; // 가로 길이
    boolean[][] visited;
    int[][] board;
    
    class Result {
        boolean win; // true : 이김, false : 짐
        int step; // 서로 이동한 횟수
        
        Result(boolean win, int step) {
            this.win = win;
            this.step = step;
        }
    }
    
    // true : board 안에 있음
    public boolean inBoard(int x, int y) {
        return 0<=y && y<Y && 0<=x && x<X;
    }
    
    public Result recursive(int[] aloc, int[] bloc, int step) {
        boolean isWin = true;
        boolean isMove = false;
        int[] dy = { 1, -1, 0, 0 };
        int[] dx = { 0, 0, 1, -1 };
        List<Integer> winStep = new ArrayList<>();
        List<Integer> loseStep = new ArrayList<>();
        
        int[] now = step%2 == 0 ? aloc : bloc;
        for(int i=0; i<dy.length; i++) {
            int ny = now[0] + dy[i];
            int nx = now[1] + dx[i];
            
            // 이동가능할 경우
            if(inBoard(nx, ny) && board[ny][nx] == 1 && !visited[ny][nx]) {
                isMove = true;
                
                // 같은 위치에 있는 경우
                if(aloc[0] == bloc[0] && aloc[1] == bloc[1]) {
                    return new Result(true, step+1);
                }
                
                visited[now[0]][now[1]] = true;
                Result result = step%2 == 0 ? recursive(new int[]{ny, nx}, bloc, step+1)
                                    : recursive(aloc, new int[]{ny, nx}, step+1);
                visited[now[0]][now[1]] = false;
                
                isWin &= result.win;
                if(result.win) winStep.add(result.step);
                else loseStep.add(result.step);
            }
        }
        
        // 이동할 수 없는 경우
        if(!isMove) return new Result(false, step);
        // 상대방이 이긴 경우 -> winStep 중 가장 큰 값 구하기
        if(isWin) return new Result(false, winStep.stream().max(Integer::compare).get());
        
        // 상대방이 이길 수도 질수도 있는 경우 -> 이길 수 있는 경우 가장 적은 step 구하기
        return new Result(true, loseStep.stream().min(Integer::compare).get());
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        Y = board.length;
        X = board[0].length;
        visited = new boolean[Y][X];
        this.board = board;
        
        int answer = recursive(aloc, bloc, 0).step;
        return answer;
    }
}