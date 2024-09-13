import java.util.*;

class Node {
    int x;
    int y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length; // y 길이
        int m = maps[0].length; // x 길이
        int arriveY = n - 1;
        int arriveX = m - 1;
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        
        // 방문한 곳과 이동 횟수
        int[][] visited = new int[n][m];
        visited[0][0] = 1;
        visited[arriveY][arriveX] = -1;
        
        // bfs
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll(); // 현재 위치
                        
            // 이동할 수 있는 위치가 있다면 다음 이동할 위치로 추가
            for(int i=0; i<dx.length; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(!move(nx, ny, n, m)) continue; // maps 밖인 경우
                if(maps[ny][nx] == 0) continue; // 벽인 경우
                
                // 처음 방문한 경우
                if(visited[ny][nx] == 0 || visited[ny][nx] == -1) {
                    queue.add(new Node(nx, ny));
                    visited[ny][nx] = visited[current.y][current.x] + 1;
                }
            }
        }
        
        return visited[arriveY][arriveX];
    }
    
    public boolean move(int x, int y, int n, int m) {
        if(0<=x && x<m && 0<=y && y<n) return true;
        
        return false;
    }
}