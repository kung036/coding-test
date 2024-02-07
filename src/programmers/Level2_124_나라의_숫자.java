package programmers;

import java.util.*;

// 10진수를 3진수로 변경하는 알고리즘
public class Level2_124_나라의_숫자 {
    public String solution(int n) {
        String answer = "";
        List<Integer> result = new ArrayList<>();

        // 몫 구하기
        while (n != 0) {
            result.add(n % 3);
            n /= 3;
        }

        // 나머지가 0인 경우, 4로 대체 후 몫에서 1을 빼기
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) == 0 || result.get(i) == -1) {
                result.set(i, 4 + result.get(i) * 2);
                result.set(i + 1, result.get(i + 1) - 1);
            }
        }

        if (result.get(result.size() - 1) == 0) result.remove(result.size() - 1);

        // 124 나라의 숫자 구하기
        for (int i = result.size() - 1; i >= 0; i--) {
            answer += result.get(i);
        }

        return answer;
    }
}