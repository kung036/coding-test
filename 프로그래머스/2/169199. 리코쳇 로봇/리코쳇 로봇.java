import java.util.*;

class Node {
    int x;
    int y;
    String dir = ""; // u, d, l, r
    int move = 0;
    
    Node(int x, int y, String dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Node(int x, int y, String dir, int move) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.move = move;
    }
}

class Solution {
    String[] dir = { "u", "d", "l", "r" };
    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };
    int row;
    int col;

    public int solution(String[] board) {
        row = board.length;
        col = board[0].length();
        boolean[][][] visited = new boolean[row][col][4]; // 방향별 방문 체크

        Node start = findNode(board, 'R');
        Node finish = findNode(board, 'G');

        Queue<Node> q = new ArrayDeque<>();
        // 초기 위치에서 4방향으로 이동 가능
        for(int i = 0; i < 4; i++) {
            Node next = stopNode(board, start, dir[i]);
            if(next.x != start.x || next.y != start.y) {
                q.add(new Node(next.x, next.y, dir[i], 1));
                visited[next.y][next.x][i] = true;
            }
        }

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(finish.y == cur.y && finish.x == cur.x) {
                return cur.move;
            }

            for(int i = 0; i < 4; i++) {
                Node next = stopNode(board, cur, dir[i]);
                if(next.x == cur.x && next.y == cur.y) continue;
                if(visited[next.y][next.x][i]) continue;

                visited[next.y][next.x][i] = true;
                q.add(new Node(next.x, next.y, dir[i], cur.move + 1));
            }
        }

        return -1; // 도달할 수 없는 경우
    }

    
    // 현재 방향에 대한 인덱스 찾기
    public int curDir(String dir) {
        if(dir.equals("u")) return 0;
        else if(dir.equals("d")) return 1;
        else if(dir.equals("l")) return 2;
        return 3;
    }
    
    // 미끄러지는 위치(종료 위치)
    public Node stopNode(String[] board, Node node, String dir) {
        Node stop = new Node(node.x, node.y, dir);
        int nx = dx[curDir(dir)];
        int ny = dy[curDir(dir)];
        
        while(true) {
            int nextX = stop.x + nx;
            int nextY = stop.y + ny;
            // board를 벗어난 경우
            if(nextX < 0 || col <= nextX || nextY < 0 || row <= nextY) break;
            // 장애물인 경우
            if(board[nextY].charAt(nextX) == 'D') break;
            stop.x = nextX;
            stop.y = nextY;
        }
        
        return stop;
    }
    
    // 시작, 종료 위치 찾기
    public Node findNode(String[] board, char find) {
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(board[i].charAt(j) == find) return new Node(j, i);
            }
        }
        
        return null;
    }
}