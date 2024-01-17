package programmers;

import java.util.*;

public class Level2_귤_고르기 {
    public int solution(int k, int[] tangerines) {
        int answer = 0;

        // 1. MAP 생성(귤의 크기, 귤의 개수)
        Map<Integer, Integer> scales = new HashMap<>();

        // 2. map에 귤의 크기에 따른 개수 저장
        for(int t : tangerines) {
            scales.put(t, scales.getOrDefault(t, 0) + 1);
        }

        // 3. 개수가 가장 큰 순으로 귤의 크기 정렬(오름차순)
        int[] scale = scales.values()
                .stream()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        // 4. k - (귤의 개수) <= 0 될때까지의 귤의 개수 구하기
        for(int s : scale) {
            k -= s;
            answer++;
            if(k <= 0) break;
        }

        return answer;
    }
}