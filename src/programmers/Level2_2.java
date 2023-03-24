package programmers;

import java.util.Arrays;
import java.util.*;

// 리코쳇 로봇
public class Level2_2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] board = new String[]{
                "...D..R", ".D.G...", "....D.D", "D....D.", "..D...."
        };

        int answer = s.solution(board);
        System.out.println("answer : " + answer); // 7

        System.out.println();

        String[] board2 = new String[]{
                ".D.R", "....", ".G..", "...D"
        };
        answer = s.solution(board2);
        System.out.println("answer : " + answer); // -1
    }

    static class Solution {
        public int solution(String[] board) {
            int answer = 0;
            int[] list = firstCheck(board);
            boolean[][] visited = new boolean[board.length][board[0].length()];

            if (list[0] == -1) answer = -1;
            else answer = dfs(board, visited, answer, 0, list[1], list[2]);

            return answer;
        }

        public int dfs(String[] board, boolean[][] visited, int answer, int count, int y, int x) {
            visited[y][x] = true;

            // Base Case
            if (board[y].charAt(x) == 'G') {
                if (answer == 0 || count < answer) return count;
                else return answer;
            }

            // Recursice Case
            count++;
            int[] dir_x = { 0, -1, 0, 1 };
            int[] dir_y = { -1, 0, 1, 0 };
            boolean[][] visited_clone = copyArray(visited);

            for(int i=0; i<dir_x.length; i++) {
                if(x+dir_x[i] >= 0 &&
                        y+dir_y[i] >= 0 &&
                        x+dir_x[i] < board[0].length() &&
                        y+dir_y[i] < board.length) {
                    int move_x = x;
                    int move_y = y;
                    // D가 있을 때까지 이동하기
                    for(; move_x>=0 && move_y >=0 && move_x<board[0].length() && move_y<board.length;
                                                                    move_x+=dir_x[i], move_y+=dir_y[i]) {
                        if(board[move_y].charAt(move_x) == 'D') break;
                    }
                    move_x += -1*dir_x[i];
                    move_y += -1*dir_y[i];

                    if(board[move_y].charAt(move_x) == 'G') { // G에 도달했을 때
                        if(answer == 0 || count < answer) answer = count;
                        break;
                    } else if(!visited[move_y][move_x]) { // 방문한 적이 없는 경우
                        int tmp = dfs(board, visited_clone, answer, count, move_y, move_x);
                        if(answer == 0 || tmp < answer) answer = tmp;
                    }
                }
            }

            return answer;
        }

        // 이중배열 깊은복사
        boolean[][] copyArray(boolean[][] arr) {
            boolean[][] copy = new boolean[arr.length][arr[0].length];
            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr[i].length; j++) {
                    copy[i][j] = arr[i][j];
                }
            }

            return copy;
        }

        // G, R 위치 찾기 & 결과값이 있는지 확인
        public int[] firstCheck(String[] board) {
            int[] list = new int[3];
            list[0] = -2;
            list[1] = -1;
            list[2] = -1;

            for (int i = 0; i < board.length; i++) {
                if (board[i].contains("G") || board[i].contains("R")) {
                    for (int j = 0; j < board[i].length(); j++) {
                        if (board[i].charAt(j) == 'G') {
                            list[0] = -1;
                            if ((i + 1) < board.length && board[i + 1].charAt(j) == 'D') list[0] = 0;
                            if ((i - 1) >= 0 && board[i - 1].charAt(j) == 'D') list[0] = 0;
                            if ((j + 1) < board.length && board[i].charAt(j + 1) == 'D') list[0] = 0;
                            if ((j - 1) >= 0 && board[i].charAt(j - 1) == 'D') list[0] = 0;
                        } else if (board[i].charAt(j) == 'R') {
                            list[1] = i;
                            list[2] = j;
                        }
                    }

                    if (list[0] != -2 && list[1] != -1) break;
                }
            }

            return list;
        }
    }
}

