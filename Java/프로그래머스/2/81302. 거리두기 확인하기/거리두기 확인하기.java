class Solution {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = isValidPlace(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean isValidPlace(String[] place) {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (place[x].charAt(y) == 'P' && !checkFrom(place, x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkFrom(String[] place, int x, int y) {
        boolean[][] visited = new boolean[5][5];
        return dfs(place, x, y, x, y, 0, visited);
    }

    private boolean dfs(String[] place, int sx, int sy, int x, int y, int dist, boolean[][] visited) {
        if (dist > 2) return true;
        if (dist > 0 && place[x].charAt(y) == 'P') return false;
        if (place[x].charAt(y) == 'X') return true;

        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            if (visited[nx][ny]) continue;

            if (!dfs(place, sx, sy, nx, ny, dist + 1, visited)) {
                return false;
            }
        }

        return true;
    }
}