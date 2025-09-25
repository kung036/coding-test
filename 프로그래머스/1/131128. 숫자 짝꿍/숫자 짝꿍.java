import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] x = new int[11];
        int[] y = new int[11];
        
        for(int i=0; i<Math.max(X.length(), Y.length()); i++) {
            if(i < X.length()) x[Integer.valueOf(X.charAt(i)+"")]++;
            if(i < Y.length()) y[Integer.valueOf(Y.charAt(i)+"")]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=10; i>0; i--) {
            int n = Math.min(x[i], y[i]);
            sb.append((i+"").repeat(n));
        }
        
        String answer = sb.toString();
        if(answer.isEmpty() && Math.min(x[0], y[0]) > 0) answer = "0";
        else answer += "0".repeat(Math.min(x[0], y[0]));
        
        return answer.isEmpty() ? "-1" : answer;
    }
}