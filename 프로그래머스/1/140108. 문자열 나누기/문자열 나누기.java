class Solution {
    public int solution(String s) {
        int answer = 0;
        char start = '1';
        int x = 0;
        int notX = 0;
        
        for(char c : s.toCharArray()) {
            if(start == '1') start = c;
            if(c == start) x++;
            else notX++;
            if(x == notX) {
                answer++;
                start = '1';
                x = 0;
                notX = 0;
            }
        }
        if(start != '1') answer++;
        
        return answer;
    }
}