import java.util.*;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        // [x,y]
        // up : [0,1], down : [0,-1], left : [-1,0], right : [1,0]
        // [0,0] -> keyinput으로 이동
        
        // 위치
        int x = 0;
        int y = 0;
        int w = (board[0]-1)/2; // 최대 가로 좌표
        int h = (board[1]-1)/2; // 최대 세로 좌표
        
        // 이동
        int[] dy = {0,0,1,-1};
        int[] dx = {-1,1,0,0};
        Map<String, Integer> map = new HashMap<>();
        map.put("left", 0);
        map.put("right", 1);
        map.put("up", 2);
        map.put("down", 3);        
        
        // 이동
        for(String move : keyinput) {
            int ny = y + dy[map.get(move)];
            int nx = x + dx[map.get(move)];
            
            // 맵을 벗어나지 않은지 확인
            if(ny<(-1*h) || h<ny || nx<(-1*w) || w<nx) continue;
            
            y = ny;
            x = nx;
        }
        
        return new int[]{x, y};
    }
}