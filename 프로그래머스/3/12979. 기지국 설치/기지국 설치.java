import java.util.*;

class Solution {
    int start;
    int end;
    int w, n;
    
    public int solution(int n, int[] stations, int w) {        
        this.w = w;
        this.n = n;
        
        int answer = 0;
        int index = 1;
        int move = w*2+1;
        
        int i = 0;
        int interval, tmp;
        
        while(index <= n) {
            if(i<stations.length) {
                findNext(stations, i++);
                if(start <= index) {
                    index = end+1;
                    continue;
                }
            } else {
                start = n+1;
                end = n;
            }
            interval = start - index;
            if(interval%move == 0) answer += interval/move;
            else answer += interval/move+1;
            index = end + 1;
            // System.out.println(start + " " + end + " " + interval);
        }
        
        return answer;
    }
    
    public void findNext(int[] stations, int i) {
        // start
        if(stations[i]-w < 1) start = 1;
        else start = stations[i]-w;
        
        // end
        if(n < stations[i]+w) end = n;
        else end = stations[i]+w;
    }
}