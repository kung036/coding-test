import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        // 몸무게별 등장 횟수 저장
        Map<Integer, Long> weightCount = new HashMap<>();

        for (int weight : weights) {
            weightCount.put(weight, weightCount.getOrDefault(weight, 0L) + 1);
        }

        // 같은 무게끼리 조합
        for (int weight : weightCount.keySet()) {
            long count = weightCount.get(weight);
            if (count > 1) {
                answer += (count * (count - 1)) / 2; // 같은 무게 조합
            }
        }

        // 시소 짝꿍 계산 (비율: 2:3, 2:4(1:2), 3:4)
        for (int weight : weightCount.keySet()) {
            long count = weightCount.get(weight);

            // 2:3 비율
            if (weight % 3 == 0 && weight / 3 * 2 <= 1000) {
                int targetWeight = weight / 3 * 2;
                if (weightCount.containsKey(targetWeight)) {
                    answer += count * weightCount.get(targetWeight);
                }
            }

            // 2:4(1:2) 비율
            if (weight % 2 == 0 && weight / 2 <= 1000) {
                int targetWeight = weight / 2;
                if (weightCount.containsKey(targetWeight)) {
                    answer += count * weightCount.get(targetWeight);
                }
            }

            // 3:4 비율
            if (weight % 4 == 0 && weight / 4 * 3 <= 1000) {
                int targetWeight = weight / 4 * 3;
                if (weightCount.containsKey(targetWeight)) {
                    answer += count * weightCount.get(targetWeight);
                }
            }
        }

        return answer;
    }
}
