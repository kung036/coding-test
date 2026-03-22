import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = -1;
        int len = dartResult.length();
        for (int i = 0; i < len; i++) {
            char c = dartResult.charAt(i);
            // 점수 판별(10 처리 포함)
            if (Character.isDigit(c)) {
                idx++;
                if (c == '1' && i + 1 < len && dartResult.charAt(i + 1) == '0') {
                    scores[idx] = 10;
                    i++; // 0과 같이 소비
                } else {
                    scores[idx] = c - '0';
                }
            } else if (c == 'S') {
                scores[idx] = (int)Math.pow(scores[idx], 1);
            } else if (c == 'D') {
                scores[idx] = (int)Math.pow(scores[idx], 2);
            } else if (c == 'T') {
                scores[idx] = (int)Math.pow(scores[idx], 3);
            } else if (c == '*') {
                scores[idx] *= 2;
                if (idx > 0) scores[idx - 1] *= 2;
            } else if (c == '#') {
                scores[idx] *= -1;
            }
        }
        return scores[0] + scores[1] + scores[2];
    }
}
