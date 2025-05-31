import java.util.*;

class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        c--;
        for(; c<my_string.length(); c+=m) {
            answer+=my_string.charAt(c);
        }
        return answer;
    }
}