import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // map을 이용해서 개수 비교하기
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int n;
        
        // 왼쪽 케이크와 오른쪽 케이크 초기화
        left.put(topping[0], 1);
        for(int i=1; i<topping.length; i++) {
            n = topping[i];
            right.put(n, right.getOrDefault(n, 0) + 1);
        }
        if(left.size() == right.size()) answer++;
        
        // 두 케이크 비율을 다르게 해서 비교
        for(int i=1; i<topping.length; i++) {
            n = topping[i];
            left.put(topping[i], left.getOrDefault(topping[i], 0) + 1);
            if(right.get(n) == 1) right.remove(n);
            else right.put(n, right.get(n) - 1);
            
            if(left.size() == right.size()) answer++;
        }
        
        return answer;
    }
}