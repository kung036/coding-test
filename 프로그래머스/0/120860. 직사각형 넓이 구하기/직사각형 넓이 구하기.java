import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        Arrays.sort(dots, 
            (o1, o2) ->{
                if(o1 != o2) return Integer.compare(o1[0], o2[0]);
                else return Integer.compare(o1[1], o2[1]);
            } 
       );
        int r = dots[2][0] - dots[1][0];
        int c = dots[1][1] - dots[0][1];
        return r * c;
    }
}