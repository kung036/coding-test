import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int n = num_list.length;
        int[] answer = Arrays.copyOf(num_list, n+1);
        if(num_list[n-2]<num_list[n-1]) answer[n] = num_list[n-1] - num_list[n-2];
        else answer[n] = num_list[n-1] * 2;
        return answer;
    }
}