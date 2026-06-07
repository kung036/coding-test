import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);

        int answer = 0;
        int count = score.length / m;

        for (int i = 0; i < count; i++) {
            int idx = score.length - 1 - (i * m + (m - 1));
            answer += score[idx] * m;
        }

        return answer;
    }
}