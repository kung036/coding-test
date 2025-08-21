class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(char c : s.toCharArray()) {
            if('a' <= c && c <= 'z') {
                if(c+n > 'z') answer += (char)(c+n-26);
                else answer += (char)(c+n);
            } else if('A' <= c && c <= 'Z') {
                if(c+n > 'Z') answer += (char)(c+n-26);
                else answer += (char)(c+n);
            }
            else answer += c;
        }
        
        return answer;
    }
}