import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        if(num_list.length > 10) return Arrays.stream(num_list).sum();
        int answer = 1;
        for(int i : num_list) {
            answer *= i;
        }
        return answer;
    }
}