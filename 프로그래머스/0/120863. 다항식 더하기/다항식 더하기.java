class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] str = polynomial.split(" ");
        int x = 0;
        int y = 0;
        for(String s : str) {
            if(s.contains("x")) x += s.equals("x") ? 1 : Integer.valueOf(s.replace("x", ""));
            else if(!s.contains("+")) y += Integer.valueOf(s);
        }
        
        if(x != 0) {
            if(x == 1) answer += "x";
            else answer += x + "x";
        }
        if(y != 0) {
            if(answer == "") answer += y;
            else answer += " + " + y;
        }
         
        return answer;
    }
}