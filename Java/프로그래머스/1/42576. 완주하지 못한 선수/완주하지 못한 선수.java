import java.util.*;

class Solution {
    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> countMap = new HashMap<>();

        for (String participant : participants) {
            countMap.put(participant, countMap.getOrDefault(participant, 0) + 1);
        }

        for (String completion : completions) {
            int count = countMap.get(completion);
            if (count == 1) countMap.remove(completion);
            else countMap.put(completion, count - 1);
        }

        return countMap.keySet().iterator().next();
    }
}