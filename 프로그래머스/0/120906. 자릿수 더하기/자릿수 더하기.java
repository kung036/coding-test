import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(char c : String.valueOf(n).toCharArray()) {
            answer += Integer.valueOf(c+"");
        }
        
        return answer;
    }
}