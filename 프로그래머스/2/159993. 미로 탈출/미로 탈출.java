import java.util.*;

class Node {
    int x;
    int y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean isArrive(Node N) {
        if(N.x == x && N.y == y) return true;
        return false;
    }
}

class Solution {
    int n = -1;
    int m = -1;
    String[] maps;
    
    public int solution(String[] maps) {
        // S -> L -> E
        // O 통로 이동하기
        // BFS로 L로 이동하고, L까지 도착하면 E로 이동하기
        
        // n : 가로 길이, m : 세로 길이
        n = maps[0].length();
        m = maps.length;
        this.maps = maps;
        
        int[][] visitedL = new int[m][n]; // 레버까지의 방문거리
        int[][] visitedE = new int[m][n]; // 도착지점까지의 방문거리
        Node S = new Node(-1, -1); // 시작 위치
        Node L = new Node(-1, -1); // 레버의 위치
        Node E = new Node(-1, -1); // 도착 위치
        
        // 위치 찾기
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                if('S' == maps[i].charAt(j)) S = new Node(j, i);
                if('L' == maps[i].charAt(j)) L = new Node(j, i);
                if('E' == maps[i].charAt(j)) E = new Node(j, i);
            }
        }
        
        // 레버까지 이동
        bfs(S, L, visitedL);

        if(visitedL[L.y][L.x] == 0) return -1; // 레버까지 도착하지 못한 경우

        // 도착 위치까지 이동
        bfs(L, E, visitedE);
        
        if(visitedE[E.y][E.x] == 0) return -1; // 도착위치까지 도착하지 못한 경우
        
        return visitedL[L.y][L.x] + visitedE[E.y][E.x]; // 레버를 당긴 후 탈출 시간
    }
    
    // S : 시작위치, E : 도착위치, visited : 거리
    public void bfs(Node S, Node E, int[][] visited) {
        int[] dy = { 0, 0, -1, 1 };
        int[] dx = { -1, 1, 0, 0 };

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(S);

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.isArrive(E)) break; // 레버까지 도착한 경우
            
            for(int i=0; i<dy.length; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                
                if(ny<0 || m<=ny || nx<0 || n<=nx) continue; // 미로 밖인 경우
                if(maps[cur.y].charAt(cur.x) == 'X') continue; // 벽인 경우
                if(visited[ny][nx] == 0) { // 아직 방문하지 않은 경우
                    visited[ny][nx] = visited[cur.y][cur.x] + 1;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }
}