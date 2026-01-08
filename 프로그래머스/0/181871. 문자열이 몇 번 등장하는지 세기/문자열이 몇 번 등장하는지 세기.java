import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(myString.substring(0, pat.length()));
        for(int i=0; i+pat.length()<myString.length(); i++) {
            if(sb.toString().equals(pat)) answer++;
            sb.deleteCharAt(0).append(myString.charAt(i+pat.length()));
        }
        if(sb.toString().equals(pat)) answer++;
    
        return answer;
    }
}