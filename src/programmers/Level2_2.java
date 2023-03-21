package programmers;

// 리코쳇 로봇
public class Level2_2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] board = new String[]{
                "...D..R", ".D.G...", "....D.D", "D....D.", "..D...."
        };

        int answer = s.solution(board);
        System.out.println("answer : " + answer); // 7

        String[] section2 = new String[]{
                ".D.R", "....", ".G..", "...D"
        };
        answer = s.solution(board);
        System.out.println("answer : " + answer); // -1
    }

    static class Solution {
        public int solution(String[] board) {
            int answer = 0;
            int[] list = firstCheck(board);
            System.out.println(list[0]);

            if (list[0] == -1) answer = -1;
            else {
                answer = dfs(board, answer, 0, list[1], list[2]);
            }

            return answer;
        }

        public int dfs(String[] board, int answer, int count, int y, int x) {
            System.out.println(y + " " + x);
            if (board[y].charAt(x) == 'G') {
                if (count < answer) return count;
                else return answer;
            }

            if ((y - 1) > 0) { // 상
                int i = y;
                for (; i >= 0; i--) {
                    if (board[i].charAt(x) == 'D') break;
                }
                dfs(board, answer, count + 1, i + 1, x);
            }
            if ((y + 1) < board.length) { // 하
                int i = y;
                for (; i < board.length; i++) {
                    if (board[i].charAt(x) == 'D') break;
                }
                dfs(board, answer, count + 1, i - 1, x);
            }
            if ((x + 1) < board.length) { // 좌
                int i = x;
                for (; i < board.length; i++) {
                    if (board[y].charAt(i) == 'D') break;
                }
                dfs(board, answer, count + 1, y, i - 1);
            }
            if ((x - 1) > 0) { // 우
                int i = x;
                for (; i >= 0; i--) {
                    if (board[y].charAt(i) == 'D') break;
                }
                dfs(board, answer, count + 1, y, i + 1);
            }

            return answer;
        }

        public int[] firstCheck(String[] board) {
            int[] list = new int[3];
            list[0] = -2;
            list[1] = -1;
            list[2] = -1;

            for (int i = 0; i < board.length; i++) {
                if (board[i].contains("G") || board[i].contains("R")) {
                    for (int j = 0; j < board.length; j++) {
                        if (board[i].charAt(j) == 'G') {
                            list[0] = -1;
                            if (i - 1 >= 0) System.out.println(board[i - 1].charAt(j) + " " + i + " " + j);
                            if ((i + 1) < board.length && board[i + 1].charAt(j) == 'D') list[0] = 0;
                            if ((i - 1) >= 0 && board[i - 1].charAt(j) == 'D') list[0] = 0;
                            if ((j + 1) < board.length && board[i].charAt(j + 1) == 'D') list[0] = 0;
                            if ((j - 1) >= 0 && board[i].charAt(j - 1) == 'D') list[0] = 0;
                            continue;
                        }
                        if (board[i].charAt(j) == 'R') {
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

