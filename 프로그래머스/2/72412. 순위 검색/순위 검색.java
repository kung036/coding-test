import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (String line : info) {
            String[] tokens = line.split(" ");
            String[] cond = Arrays.copyOfRange(tokens, 0, 4);
            int score = Integer.parseInt(tokens[4]);

            for (int mask = 0; mask < 16; mask++) {
                StringBuilder key = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    if ((mask & (1 << i)) != 0) {
                        key.append(cond[i]);
                    } else {
                        key.append("-");
                    }
                    key.append(" ");
                }
                map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(score);
            }
        }

        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        int[] answer = new int[query.length];
        for (int q = 0; q < query.length; q++) {
            String line = query[q].replace(" and ", " ");
            String[] tokens = line.split(" ");
            String key = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3] + " ";
            int x = Integer.parseInt(tokens[4]);

            List<Integer> scores = map.get(key);
            if (scores == null) {
                answer[q] = 0;
            } else {
                answer[q] = scores.size() - lowerBound(scores, x);
            }
        }

        return answer;
    }

    // scores(오름차순)에서 x 이상인 첫 위치를 반환
    private int lowerBound(List<Integer> scores, int x) {
        int lo = 0, hi = scores.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (scores.get(mid) < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}