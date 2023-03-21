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
            System.out.println("dfs : " + y + " " + x);
            if (board[y].charAt(x) == 'G') {
                System.out.println(answer + " " + count);
                if (answer == 0 || count < answer) return count;
                else return answer;
            }

            if ((y - 1) > 0) { // 상
                int i = y;
                for (; i >= 0; i--) {
                    if (board[i].charAt(x) == 'D') break;
                }

                if(board[i+1].charAt(x) == 'G') {
                    System.out.println(answer + " " + count);
                    if (answer == 0 || count < answer) answer = count;
                } else if(i+1 != y && !visited[i+1][x])
                    if(count+1 < dfs(board, visited.clone(), answer, count + 1, i + 1, x))
                        answer = count + 1;
            }
            if ((x - 1) > 0) { // 좌
                int i = x;
                for (; i >= 0; i--) {
                    if (board[y].charAt(i) == 'D') break;
                }

                if(board[y].charAt(i+1) == 'G') {
                    System.out.println(answer + " " + count);
                    if (answer == 0 || count < answer) answer = count;
                } else if(i+1 != x && !visited[y][i+1])
                    if(count+1 < dfs(board, visited.clone(), answer, count + 1, y, i + 1))
                        answer = count + 1;
            }
            if ((y + 1) < board.length) { // 하
                int i = y;
                for (; i < board.length; i++) {
                    if (board[i].charAt(x) == 'D') break;
                }

                if(board[i-1].charAt(x) == 'G') {
                    System.out.println(answer + " " + count);
                    if (answer == 0 || count < answer) answer = count;
                } else if(i-1 != y && !visited[i-1][x])
                    if(count+1 < dfs(board, visited.clone(), answer, count + 1,i - 1, x))
                        answer = count + 1;
            }
            if ((x + 1) < board.length) { // 우
                int i = x;
                for (; i < board.length; i++) {
                    if (board[y].charAt(i) == 'D') break;
                }
                if(board[y].charAt(i-1) == 'G') {
                    System.out.println(answer + " " + count);
                    if (answer == 0 || count < answer) answer = count;
                } else if(i-1 != x && !visited[y][i-1])
                    if(count+1 < dfs(board, visited.clone(), answer, count + 1,y, i - 1))
                        answer = count + 1;
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

