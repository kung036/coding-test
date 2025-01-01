import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        // X : 바다, 숫자 : 무인도(서로 연결됨) -> 머물 수 있는 날짜
        // 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순
        // 없으면 -1 반환
        
        // bfs로 서로 연결된 무인도 연결하기
        int row = maps.length; // 세로 길이
        int column = maps[0].length(); // 가로 길이
        int sum = 0; // 각 섬의 채류 가능 일수
        boolean[][] visited = new boolean[row][column];
        List<Integer> answer = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                // 이미 방문하거나 바다면 건너띄기
                if(visited[i][j] || maps[i].charAt(j) == 'X') continue;
                
                q.add(new int[]{i,j});
                sum = 0;
                while(!q.isEmpty()) {
                    int y = q.peek()[0];
                    int x = q.poll()[1];
                    if(visited[y][x]) continue;
                    visited[y][x] = true;
                    sum += Integer.valueOf(maps[y].charAt(x)+"");

                    // 상하좌우 확인 -> 연결되고 방문되지 않은 무인도 확인
                    for(int k=0; k<4; k++) {
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if(ny<row && 0<=ny && nx<column && 0<=nx) {
                            if(!visited[ny][nx] && maps[ny].charAt(nx) != 'X')
                                q.add(new int[]{ny, nx});
                        }
                    }
                }
                answer.add(sum);
            }
        }
        
        if(answer.isEmpty()) return new int[]{-1};
        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}