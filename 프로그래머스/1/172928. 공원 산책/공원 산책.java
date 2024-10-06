class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 이동 좌표
        int x = 0;
        int y = 0;
        
        // 공원 크기
        int h = park.length;
        int w = park[0].length();
        
        // 시작 좌표 찾기
        for(int i=0; i<h; i++) {
            if(park[i].contains("S")) {
                y = i;
                x = park[i].indexOf("S");
            }
        }
        
        // 이동하기
        int[] dy = new int[]{0, 0, 1, -1}; // W E S N
        int[] dx = new int[]{-1, 1, 0, 0};
        for(String route : routes) {
            // 이동할 좌표
            String dir = route.split(" ")[0];
            int move = Integer.valueOf(route.split(" ")[1]);
            int index = 0;            
            if(dir.equals("E")) index = 1;
            else if(dir.equals("S")) index = 2;
            else if(dir.equals("N")) index = 3;
             
            int ny = y + dy[index] * move;
            int nx = x + dx[index] * move;

            // 공원에서 벗어난 경우
            // System.out.println("=" + dir + " " + ny + " " + nx);
            if(nx < 0 || w <= nx || ny < 0 || h <= ny) continue;
            
            // 장애물인 경우
            boolean b = true;
            for(int i=1; i<=move; i++) {
                ny = y + dy[index] * i;
                nx = x + dx[index] * i;
                // System.out.println("-> " + dir + " " + ny + " " + nx + " " + park[ny].charAt(nx));
                if(park[ny].charAt(nx) == 'X') {
                    b = false;
                    break;
                }
            }
            
            if(b) {
                y = ny;
                x = nx;
                // System.out.println(dir + " " + y + " " + x);
            }
        }
        
        return new int[]{y, x};
    }
}