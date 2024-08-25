import java.util.*;

class Node {
    String dir1; // 방향1
    String dir2; // 방향2
}

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        // UDRL의 xy 좌표를 배열로 정리하기
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        // 현재 좌표
        int x = 0;
        int y = 0;
        
        // 이동 좌표 구하기 - 좌표값을 set에 저장
        Set<String> set = new HashSet<>();
        for(String dir : dirs.split("")) {
            // 이동할 좌표구하기
            int moveIdx = moveIdx(dir);
            int moveX = x + dx[moveIdx];
            int moveY = y + dy[moveIdx];
            
            // 좌표범위에 벗어나는지 확인
            if(!check(moveX, moveY))  continue; // 이동하지 못한 경우
            
            // 이동한 좌표값 저장하기(양방향 이동하는 방법 저장)
            String dir1 = moveX+","+moveY + "-" + x+","+y;
            String dir2 = x+","+y + "-" + moveX+","+moveY;
            set.add(dir1);
            set.add(dir2);

            // 좌표범위에 있는 경우에만 이동
            x = moveX;
            y = moveY;
        }
        
        // set의 길이 반환
        return set.size() / 2;
    }
    
    // 이동할 좌표의 index 구하기
    public int moveIdx(String dir) {
        if(dir.equals("U")) return 0;
        if(dir.equals("D")) return 1;
        if(dir.equals("R")) return 2;
        return 3;
    }
    
    // 좌표평면 내에 있는지 확인
    public boolean check(int x, int y) {
        if(-5 <= x && x <= 5 && -5 <= y && y <= 5) return true;
        return false;
    }
}