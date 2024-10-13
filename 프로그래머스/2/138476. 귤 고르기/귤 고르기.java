import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerines) {
        // 가장 많은 귤을 선택함
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int tangerine : tangerines) {
            map.put(tangerine, map.getOrDefault(tangerine,0)+1);
        }
        // System.out.println(map);
        
        List<Integer> values = map.values().stream()
            .sorted((o1, o2) -> Integer.compare(o2, o1))
            .collect(Collectors.toList());
        int answer = 0;
        
        for(int value : values) {
            k -= value;
            answer++;
            if(k<=0) break;
        }
        
        return answer;
    }
}