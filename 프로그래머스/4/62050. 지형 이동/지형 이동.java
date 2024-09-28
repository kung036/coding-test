import java.util.*;

class Node {
    int x, y, cost;
    
    Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

class Solution {
    public int solution(int[][] land, int height) {
        // land : 각 격자칸의 높이가 담긴 2차원 배열
        // height : 이동 가능한 최대 높이차
        // 모든 칸을 방문하기 위해 필요한 사다리 설치 비용의 최솟값 반환
        // 사다리 설치 비용 : 두 격자 칸의 높이
        
        // bfs로 사다리 없이 탐색가능한 구역 확인하기 -> 같은 번호로 탐색하기
        // 모든 구역을 탐색한 후 최소 비용의 사다리 설치 비용 구하기
        
        int N = land.length;
        boolean[][] visited = new boolean[N][N];
        
        // 사다리 없이 이동 가능한 범위 구현
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        int answer = 0;
        
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.add(new Node(0, 0, 0));
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(visited[now.y][now.x]) continue; // 방문한 경우

            visited[now.y][now.x] = true;
            answer += now.cost;

            for(int i=0; i<4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;
                
                // 격자를 벗어난 경우
                if(nx < 0 || ny < 0 || N <= nx || N <= ny) continue;

                // 방문한 경우
                if(visited[ny][nx]) continue;

                // 사다리를 연결해야하는 경우
                int cost = Math.abs(land[now.y][now.x]-land[ny][nx]);
                if(cost <= height) cost = 0;
                
                queue.add(new Node(nx, ny, cost));
            }
        }
         
        return answer;
    }
}