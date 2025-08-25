import java.util.*;

class Solution {
    public int solution(String s) {
        String[] str = new String[] {
            "zero", "one", "two", "three", "four", 
            "five", "six", "seven", "eight", "nine"
        };
        
        for(int i=0; i<10; i++) {
            s = s.replace(str[i], i+"");
        }
        
        return Integer.valueOf(s);
    }
}