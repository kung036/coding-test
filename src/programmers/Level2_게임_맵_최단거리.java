package programmers;
import java.util.*;

// 정확도 통과, 효율성 통과X

// 최단거리 구하기 - BFS
public class Level2_게임_맵_최단거리 {
    class Solution {
        // 방문여부
        // boolean[][] visited;

        // 최소값
        // int min = -1

        int[][] maps;
        Queue<int[]> queue;

        public int solution(int[][] maps) {
            int answer = 0;
            this.maps = maps;

            // 최단거리 도착(BFS, Queue)
            queue = new LinkedList<>();

            // 현재 위치
            int y = 0;
            int x = 0;

            // 도착 위치
            int m = maps.length - 1;
            int n = maps[0].length - 1;

            queue.offer(new int[]{0, 0, 1});
            while (true) {
                if (queue.isEmpty()) break;

                // 방문할 위치
                int[] cur = queue.poll();
                y = cur[0];
                x = cur[1];
                maps[y][x] += cur[2];

                // 현재 위치가 도착 위치인 경우
                if (y == m && x == n) break;

                check(y, x);
            }

            answer = maps[m][n] == 1 ? -1 : maps[m][n] - 1;

            return answer;
        }

        // 다음 방문할 위치를 queue에 저장
        public boolean check(int y, int x) {
            int[] dy = new int[]{0, 0, 1, -1};
            int[] dx = new int[]{1, -1, 0, 0};

            for (int i = 0; i < dy.length; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (0 <= ny && 0 <= nx && ny < maps.length && nx < maps[0].length) {
                    if (maps[ny][nx] == 1) queue.offer(new int[]{ny, nx, maps[y][x]});
                }
            }

            return false;
        }
    }
}