import java.util.*;

class Node implements Comparable<Node> {
    int x, y, w;
    char dir;
    
    Node(int x, int y, int w, char dir) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.dir = dir;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w; // 비용이 적은 순으로 정렬
    }
}

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4]; // 방향별로 최소 비용 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] directions = {'U', 'D', 'L', 'R'};

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < 4; i++) {
            cost[0][0][i] = 0; // 출발점에서 각 방향에 대한 초기 비용
        }
        pq.add(new Node(0, 0, 0, 'x')); // 시작점

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            // 도착점에 도달한 경우
            if (now.x == n - 1 && now.y == n - 1) {
                return now.w;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                char nextDir = directions[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[ny][nx] == 1) continue;

                int newCost = now.w + (now.dir == nextDir || now.dir == 'x' ? 100 : 600);
                
                if (newCost < cost[ny][nx][i]) {
                    cost[ny][nx][i] = newCost;
                    pq.add(new Node(nx, ny, newCost, nextDir));
                }
            }
        }

        return -1; // 경주로를 만들 수 없는 경우
    }
}
