import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skills) {
        // 행과 열의 누적합 아이디어를 이용해서 해결
        
        // 1 1 0 0
        // 1 1 0 0
        // 0 0 0 0
        // -> 아래와 같이 4지점 표시만으로 해결
        //  1 0 -1 0
        //  0 0  0 0
        // -1 0  1 0
        
        int r = board.length; // 세로 길이
        int c = board[0].length; // 가로 길이
        int[][] memo = new int[r][c];
        
        // 누적합 계산을 위해 표시하기
        for(int[] skill : skills) {
            int degree = skill[0]==1 ? skill[5]*-1 : skill[5];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            memo[r1][c1] += degree;
            if(c2+1 != c) memo[r1][c2+1] -= degree;
            if(r2+1 != r) memo[r2+1][c1] -= degree;
            if(c2+1 != c && r2+1 != r) memo[r2+1][c2+1] += degree;
        }
        
        // 누적합으로 건물의 내구도 구하기 1) 오른쪽으로
        for(int i=0; i<r; i++) {
            for(int j=1; j<c; j++) {
                memo[i][j] += memo[i][j-1];
            }
        }

        // 누적합으로 건물의 내구도 구하기 2) 아래로
        for(int i=1; i<r; i++) {
            for(int j=0; j<c; j++) {
                memo[i][j] += memo[i-1][j];
            }
        }
        
        // 내구도가 1이상인 건물 개수 구하기
        int answer = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(board[i][j]+memo[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}