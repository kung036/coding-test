import java.util.*;

class Solution {
    public int solution(String[] words) {
        Arrays.sort(words);
        int n = words.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int prev = i > 0 ? lcp(words[i - 1], words[i]) : 0;
            int next = i < n - 1 ? lcp(words[i], words[i + 1]) : 0;

            // 이웃과 겹치는 최대 길이 + 1글자 더 입력해야 구분됨 (단어 길이 초과 불가)
            answer += Math.min(Math.max(prev, next) + 1, words[i].length());
        }
        return answer;
    }

    private int lcp(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int i = 0;
        while (i < len && a.charAt(i) == b.charAt(i)) i++;
        return i;
    }
}