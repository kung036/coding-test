import java.util.*;

class Solution {
    public String solution(String[] participants, String[] completions) {
        String answer = "";
        
        // 참여자 이름과 수를 넣음
        Map<String, Integer> map = new HashMap<>();
        
        for(String participant : participants) {
            if(!map.containsKey(participant)) map.put(participant, 1);
            else map.put(participant, map.get(participant)+1);
        }
        
        // 참여자들 명단에서 완주자 제거
        // 만약 2명 이상일 경우 수를 하나 없앰
        for(String completion : completions) {
            if(map.get(completion) > 1) map.put(completion, map.get(completion)-1);
            else map.remove(completion);
        }
        
        for(String str : map.keySet()) {
            answer = str;
        }
        
        return answer;
    }
}