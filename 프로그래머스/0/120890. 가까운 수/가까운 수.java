import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        int answer = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<array.length; i++) {
            if(min > Math.abs(n-array[i])) {
                answer = array[i];
                min = Math.abs(n-array[i]);
            }
        }
        
        return answer;
    }
}