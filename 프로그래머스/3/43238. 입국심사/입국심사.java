import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long)Arrays.stream(times).min().getAsInt() * n;
        long answer = right;
        
        while(left<=right) {
            long total = 0;
            long mid = (left+right)/2;
            
            for(int time : times) {
                total += mid/time;
            }
            
            if(total >= n) {
                answer = mid;
                right = mid-1;
            } else left = mid+1;
        }
        
        return answer;
    }
}