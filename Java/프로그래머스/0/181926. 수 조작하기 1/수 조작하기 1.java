class Solution {
    public int solution(int n, String control) {
        int answer = n;
        for(char c : control.toCharArray()) {
            switch(c) {
                case 'w' -> answer++;
                case 's' -> answer--;
                case 'd' -> answer+=10;
                case 'a' -> answer-=10;
            }
        }
        
        return answer;
    }
}