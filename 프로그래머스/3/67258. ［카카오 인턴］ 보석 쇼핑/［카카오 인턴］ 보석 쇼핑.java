import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 보석 종류 구하기
        Set<String> set = new HashSet<>();
        for(String gem : gems) set.add(gem);
        
        // 가장 짧은 구간 구하기
        int len = Integer.MAX_VALUE;
        int l = 0; // 왼쪽 포인트
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[2];

        for(int r=0; r<gems.length; r++) { // 오른쪽 포인트
            String gem = gems[r];
            map.put(gem, map.getOrDefault(gem,0)+1);
            
            // 보석의 종류가 1개일 때까지 반복
            while(map.get(gems[l]) > 1) {
                map.put(gems[l], map.get(gems[l])-1);
                l++;
            }
            
            // 모든 종류의 보석을 1개 이상 가진 경우
            if(map.size() == set.size() && len > r-l) {
                len = r-l;
                answer[0] = l+1;
                answer[1] = r+1;
            }
        }
        
        return answer;
    }
}