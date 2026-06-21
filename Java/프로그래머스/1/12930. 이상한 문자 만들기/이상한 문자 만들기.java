class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int count = 0;
        
        for (int i = 0; i < s.length(); i++, count++) {
            char c = s.charAt(i);
            if (c == ' ') {
                count = -1;
                answer.append(c);
            } else {
                answer.append(count % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
            }
        }
        
        return answer.toString();
    }
}