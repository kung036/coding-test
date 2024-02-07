package programmers;
import java.util.*;

public class Level2_카카오프렌즈_컬러링북 {
    class Node {
        int area; // 영역 번호
        int count; // 영역의 개수
        int color; // 색깔
    }

    // 방문여부 확인
    boolean[][] visited;

    // Queue 선언 - 방문할 원소
    Queue<int[]> queue = new LinkedList<>();

    int[][] picture;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        this.picture = picture;

        // 영역
        List<Node> nodes = new ArrayList<>();

        // 방문여부 확인
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int max = 0;
                if(!visited[i][j] && picture[i][j]!=0) { // 방문하지 않은 새로운 영역
                    int color = picture[i][j]; // 영역의 색깔
                    numberOfArea++; // 새로운 영역 추가
                    queue.offer(new int[]{i, j});

                    // 같은 색깔의 영역 방문
                    while(!queue.isEmpty()) {
                        int[] current = queue.poll(); // 현재 방문한 영역
                        int y = current[0];
                        int x = current[1];
                        visited[y][x] = true; // 방문 여부 표시
                        max++; // 영역 크기 추가

                        // 방문한 영역의 상하좌우가 같은 색깔인 경우 -> 다음 방문 예정
                        check(picture, color, y, x);
                    }

                    // 최대 영역 크기
                    if(max > maxSizeOfOneArea) maxSizeOfOneArea = max;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;


        return answer;
    }

    // 방문한 원소의 상하좌우가 같은 영역 확인
    public void check(int[][] picture, int color, int y, int x) {
        int[] dx = new int[]{ 1, -1, 0, 0 };
        int[] dy = new int[]{ 0, 0, 1, -1 };

        for(int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0<=nx && nx<picture[0].length && 0<=ny && ny<picture.length) {
                if(!visited[ny][nx] && picture[ny][nx] == color) {
                    queue.offer(new int[]{ny, nx});
                    // System.out.println("추가 >> i : " + nx + " j : " + ny);
                    visited[ny][nx] = true;
                }
            }
        }
    }
}
