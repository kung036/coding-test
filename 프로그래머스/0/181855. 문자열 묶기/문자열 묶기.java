import java.util.HashMap;

class Solution {
    public int solution(String[] strArr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strArr) {
            int len = s.length();
            map.put(len, map.getOrDefault(len, 0) + 1);
        }
        return map.values().stream().max(Integer::compare).orElse(0);
    }
}
