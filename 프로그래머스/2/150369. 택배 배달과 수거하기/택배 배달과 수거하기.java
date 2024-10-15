import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int idx = n-1;
        int del = 0; // 배달 가능한 택배 개수
        int pick = 0; // 수거 가능한 택배 개수
        
        while(0<=idx) {
            while(idx >= 0 && (deliveries[idx] == 0 && pickups[idx] == 0)) idx--;
            answer += idx+1;
            del = cap;
            pick = cap;
            
            for(int i=idx; i>=0; i--) {
               // 배달 처리
                if (deliveries[i] > 0) {
                    int deliverAmount = Math.min(del, deliveries[i]);
                    deliveries[i] -= deliverAmount;
                    del -= deliverAmount;
                }
                if(del<=0) break;
            }
            for(int i=idx; i>=0; i--) {
                // 수거 처리
                if (pickups[i] > 0) {
                    int pickupAmount = Math.min(pick, pickups[i]);
                    pickups[i] -= pickupAmount;
                    pick -= pickupAmount;
                }
                if(pick<=0) break;
            }
        }        
        
        return answer*2;
    }
}