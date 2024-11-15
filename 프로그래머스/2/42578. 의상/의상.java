import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 종류별 의상 개수 구하기
        String type = clothes[0][1];
        Map<String, Integer> map = new HashMap<>();
        for(String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0)+1);
        }
        
        // 종류 구하기
        int answer = 1;
        
        // 종류가 1개인 경우
        if(map.size() == 1) answer = map.get(type);
        else { // 종류가 여러 개인 경우
            for(String clothType : map.keySet()) {
                answer *= map.get(clothType)+1;
            }
            answer--;
        }
        
        return answer;
    }
}