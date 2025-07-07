import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int[] before = Arrays.copyOf(arr, arr.length);
        
        while(true) {
            for(int i=0; i<arr.length; i++) {
                if(arr[i] < 50 && arr[i]%2==1) arr[i] = arr[i]*2 + 1;
                else if(arr[i] >= 50 && arr[i]%2==0) arr[i] /= 2;
            }
            if(Arrays.equals(before, arr)) break;
            answer++;
            before = Arrays.copyOf(arr, arr.length);
        }
        return answer;
    }
}