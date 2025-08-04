import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int n = Math.max(arr.length, arr[0].length);
        int[][] answer = new int[n][n];
        for(int i=0; i<arr.length; i++) {
            answer[i] = Arrays.copyOf(arr[i], n);
        }
        
        return answer;
    }
}