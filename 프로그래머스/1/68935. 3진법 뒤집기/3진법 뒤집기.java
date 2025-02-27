import java.util.*;

class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        String three = sb.append(Integer.toString(n, 3)).reverse().toString();
        
        return Integer.valueOf(three, 3);
    }
}