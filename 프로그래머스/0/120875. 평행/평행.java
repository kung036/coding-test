class Solution {
    public int solution(int[][] dots) {
        int x1, x2, y1, y2;
        
        // 1-2 3-4        
        if(find(dots[0], dots[1], dots[2], dots[3]) == 1) return 1;
        // 1-3 2-4
        if(find(dots[0], dots[2], dots[1], dots[3]) == 1) return 1;
        // 1-4 2-3
        if(find(dots[0], dots[3], dots[1], dots[2]) == 1) return 1;
        
        return 0;
    }
    
    public int find(int[] x1, int[] y1, int[] x2, int[] y2) {
        int dx1 = Math.abs(y1[0] - x1[0]);
        int dy1 = Math.abs(y1[1] - x1[1]);
        int dx2 = Math.abs(y2[0] - x2[0]);
        int dy2 = Math.abs(y2[1] - x2[1]);
        
        if(dy1 == 0 && dy2 == 0) return 1;
        if((double)dx1/dy1 == (double)dx2/dy2) return 1;
        
        return 0;
    }
}