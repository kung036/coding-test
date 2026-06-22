class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int wordIdx = 0;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                wordIdx = 0;
                answer.append(c);
            } else {
                answer.append(wordIdx++ % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
            }
        }

        return answer.toString();
    }
}