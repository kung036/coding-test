import java.util.*;

class Solution {
    public int solution(int[] array) {
        int[] arr = new int[1000];
        for(int i : array) {
            arr[i]++;
        }
        int max = Arrays.stream(arr).max().orElse(0);
        int answer = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == max) {
                if(answer != -1) {
                    answer = -1;
                    break;
                }
                answer = i;
            }
        }
        
        return answer;
    }
}