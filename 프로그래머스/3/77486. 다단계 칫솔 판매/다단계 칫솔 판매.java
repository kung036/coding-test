import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 인접 리스트를 이용해서 트리 구현
        // seller를 돌면서 root 노드까지 이익을 10%씩 분배
        
        int n = enroll.length;
        
        // 트리 구현(자식노드 - 부모노드)
        Map<String, String> tree = new HashMap<>(); // 피라미드 구조
        Map<String, Integer> profit = new HashMap<>(); // 수익
        for(int i=0; i<n; i++) {
            tree.put(enroll[i], referral[i]);
            profit.put(enroll[i], 0);
        }
                        
        // 판매수익
        for(int i=0; i<seller.length; i++) {
            String current = seller[i];
            amount[i] *= 100;
            int remain = 0;
            
            while(true) {
                remain = amount[i] / 10; // 10% 이익
                profit.put(current, profit.get(current)+amount[i]-remain);
                // System.out.println(current + " " + (amount[i]-remain));
                
                amount[i] = remain;
                current = tree.get(current);
                
                if(current.equals("-")) break;
                if(remain <= 0) break;
            }
        }
        
        // 반환
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            answer[i] = profit.get(enroll[i]);
        }
        
        
        return answer;
    }
}