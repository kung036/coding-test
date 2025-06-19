import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int k = 0;
        while(Math.pow(2, k) < arr.length) {
            k++;
        }
        
        return Arrays.copyOf(arr, (int) Math.pow(2, k));
    }
}