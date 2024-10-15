import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int idx = n - 1;
        
        while (idx >= 0) {
            int del = cap;
            int pick = cap;
            
            // 가장 멀리 남은 배달 또는 수거의 위치 찾기
            while (idx >= 0 && deliveries[idx] == 0 && pickups[idx] == 0) {
                idx--;
            }
            
            // 왕복 거리 더하기
            if (idx >= 0) answer += (idx + 1) * 2;

            // 현재 배달 처리
            for (int i = idx; i >= 0; i--) {
                if (deliveries[i] > 0) {
                    int deliverAmount = Math.min(del, deliveries[i]);
                    deliveries[i] -= deliverAmount;
                    del -= deliverAmount;
                }
                
                // 배달용량 소진 시 반복 종료
                if (del == 0) break;
            }

            // 현재 수거 처리
            for (int i = idx; i >= 0; i--) {
                if (pickups[i] > 0) {
                    int pickupAmount = Math.min(pick, pickups[i]);
                    pickups[i] -= pickupAmount;
                    pick -= pickupAmount;
                }
                
                // 수거용량 소진 시 반복 종료
                if (pick == 0) break;
            }
            
            // 다음 배달/수거 대상 찾기
            while (idx >= 0 && deliveries[idx] == 0 && pickups[idx] == 0) {
                idx--;
            }
        }
        
        return answer;
    }
}
