class Solution {
    int rows;
    int columns;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        this.rows = rows;
        this.columns = columns;
        // 시작 행렬 생성하기
        int[][] arr = new int[rows+1][columns+1];
        int sum = 1;
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                arr[i][j] = sum++;
            }
        }
        
        // 회전 시 최소값을 담는 배열
        int[] answer = new int[queries.length];
        
        // 회전 시키기
        int cnt = 0;
        for(int[] query : queries) {
            answer[cnt++] = rotationAndMin(arr, query);
            
            // for(int i=1; i<=rows; i++) {
            //     for(int j=1; j<=columns; j++) {
            //         System.out.printf("%2d ", arr[i][j]);
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }
        
        return answer;
    }
    
    int[] dx = { 1, 0, -1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    public int rotationAndMin(int[][] arr, int[] query) {
        int x1 = query[1];
        int y1 = query[0];
        int x2 = query[3];
        int y2 = query[2];
        
        int min = arr[y1][x1];
        
        int before = min;
        int after = min;
        int rot = 0;
        int nx = x1;
        int ny = y1;
        int stop = 0;
        
        while(true) {
            if(ny == y1 && nx == x1) stop++;
            // 좌표값 변경
            after = arr[ny][nx];
            arr[ny][nx] = before;
            before = after;
            min = Math.min(arr[ny][nx], min);
            
            // 다음 이동할 좌표
            if(nx == x2 && rot == 0) rot++;
            else if(ny == y2 && rot == 1) rot++;
            else if(nx == x1 && rot == 2) rot++;
            nx += dx[rot];
            ny += dy[rot];
            
            // while문 탈출            
            if(stop == 2) break;
        }
        
        return min;
    }
}