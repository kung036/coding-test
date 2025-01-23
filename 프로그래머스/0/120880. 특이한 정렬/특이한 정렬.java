import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        boolean[] arr = new boolean[10001];
        
        for(int i=0; i<numlist.length; i++) {
            arr[numlist[i]] = true;
        }
        
        int idx = 0;
        if(arr[n]) answer[idx++] = n;
        int left = n-1;
        int right = n+1;
        while(idx < numlist.length) {
            if(right < 10001 && arr[right]) answer[idx++] = right;
            if(0 < left && arr[left]) answer[idx++] = left;
            
            right++;
            left--;
        }
        
        return answer;
    }
}