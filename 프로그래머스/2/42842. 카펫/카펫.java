class Solution {
    public int[] solution(int brown, int yellow) {
        // 가로 x, 세로 y
        // brown = 2*x + 2*(y-2) = 2x + 2y - 4
        // yellow = (x-2) * (y-2) = xy -2x -2y + 4
        // brown + yellow = xy
        // brown = xy - yellow
        // yellow = xy - brown
        int x = 0;
        int y = 0;
        int area = brown + yellow;
        
        for(int i=3; i<=area; i++) {
            // 가로 또는 세로 길이가 아닌 경우
            if(area%i != 0) continue;
            x = i;
            y = area/i;
            if(brown == 2*x+2*y-4 && yellow == x*y-2*x-2*y+4) break;
            
            x = area/i;
            y = i;
            if(brown == 2*x+2*y-4 && yellow == x*y-2*x-2*y+4) break;
        }
        
        return new int[] {y, x};
    }
}