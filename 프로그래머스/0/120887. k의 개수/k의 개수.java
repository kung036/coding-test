import java.util.*;

class Solution {
    public int solution(int i, int j, int k) {
        char target = (char)(k + '0'); // 숫자 → 문자 변환
        int answer = 0;
        for (; i <= j; i++) {
            String numStr = Integer.toString(i);
            answer += (int) numStr.chars()
                .filter(ch -> ch == target)
                .count();
        }
        return answer;
    }
}