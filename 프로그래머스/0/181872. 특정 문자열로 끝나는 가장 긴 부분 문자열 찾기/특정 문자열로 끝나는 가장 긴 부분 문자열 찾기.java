import java.util.*;

class Solution {
    public String solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        sb.append(myString);
        for(int i=myString.length()-1; i>=0; i--) {
            if(sb.toString().endsWith(pat)) break;
            sb.deleteCharAt(i);
        }
        
        return sb.toString();
    }
}