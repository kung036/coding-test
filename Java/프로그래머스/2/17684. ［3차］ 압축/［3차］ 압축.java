import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        List<Integer> answer = new ArrayList<>();
        int idx = 27;
        int i = 0;

        while (i < msg.length()) {
            String w = String.valueOf(msg.charAt(i));
            int j = i + 1;

            while (j <= msg.length() && map.containsKey(msg.substring(i, j))) {
                w = msg.substring(i, j);
                j++;
            }

            answer.add(map.get(w));

            if (j <= msg.length()) {
                map.put(msg.substring(i, j), idx++);
            }

            i += w.length();
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}