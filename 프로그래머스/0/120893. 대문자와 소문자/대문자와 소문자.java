class Solution {
    public String solution(String my_string) {
        int a = 'a'; // 97
        int A = 'A'; // 65
        String answer = "";
        
        for(char c : my_string.toCharArray()) {            
            if('a' <= c) c-=32;
            else c+=32;
            answer += c;
        }
        
        return answer;
    }
}