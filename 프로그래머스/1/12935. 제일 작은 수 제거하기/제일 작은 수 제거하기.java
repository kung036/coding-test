import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        if(n == 1) return new int[]{-1};
        
        int min = Arrays.stream(arr).min().getAsInt();
        int[] answer = new int[n-1];
        int arrN = 0;
        
        for(int i=0; i<n; i++) {
            if(arr[i] == min) continue;
            
            answer[arrN++] = arr[i];
        }
        
        return answer;
    }
}