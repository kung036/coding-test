import java.util.*;
class Solution {
    Map<Integer, Map<String, Integer>> courseMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] courses) {
        List<String> answer = new ArrayList<>();
        
        for(int course : courses) {
            courseMap.put(course, new HashMap<>());
        }
        
        for(String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            combinations(0, chars, "");
        }
        
        for(Map<String, Integer> order : courseMap.values()) {
            order.values().stream()
                .max(Integer::compare)
                .ifPresent(max -> {
                    if(max > 1) {
                        order.entrySet().stream()
                            .filter(o -> o.getValue().equals(max))
                            .forEach(o -> answer.add(o.getKey()));
                    }
                });
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public void combinations(int idx, char[] order, String result) {
        // course에 있는 길이면 저장
        if(courseMap.containsKey(result.length())) {
            Map<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0)+1);
        }
        
        for(int i=idx; i<order.length; i++) {
            combinations(i+1, order, result+order[i]);
        }
    }
}