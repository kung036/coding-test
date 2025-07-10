import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length();
        int arrSize = (len + n - 1) / n; // 올림 처리
        String[] answer = new String[arrSize];

        for (int i = 0; i < arrSize; i++) {
            int start = i * n;
            int end = Math.min(start + n, len);
            answer[i] = my_str.substring(start, end);
        }

        return answer;
    }
}
