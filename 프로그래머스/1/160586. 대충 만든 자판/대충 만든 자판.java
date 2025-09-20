import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<String, Integer> map = new HashMap<>();
        for(String s : keymap) {
            for(int i=0; i<s.length(); i++) {
                String current = s.charAt(i)+"";
                if((map.containsKey(current) && map.get(current) > i+1) ||
                    !map.containsKey(current)) map.put(current, i+1);   
            }
        }
        
        for(int i=0; i<answer.length; i++) {
            for(int j=0; j<targets[i].length(); j++) {
                String current = targets[i].charAt(j)+"";
                if(!map.containsKey(current)) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += map.get(current);
            }
        }
        
        return answer;
    }
}