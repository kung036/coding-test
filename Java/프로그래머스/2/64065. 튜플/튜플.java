import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        // s를 {}로 나누기
        // 개수를 기준으로 오름차순 정렬
        s = s.substring(2, s.length()-2); // 처음과 끝의 {} 제거
        Map<Integer, Integer> map = new HashMap<>();
        
        // {}별로 나누기
        int index = 0;
        for(String split : s.replace("},{", ",").split(",")) {
            int key = (int)Integer.valueOf(split);
            map.put(key, map.getOrDefault(key,0)+1);
        }
        
        return map.entrySet().stream()
            .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
            .mapToInt(o -> o.getKey())
            .toArray();
    }
}