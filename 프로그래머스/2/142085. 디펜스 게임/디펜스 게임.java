import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        // 우선순위 큐를 내림차순으로 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int soldiers = n;
        
        for (int i = 0; i < enemy.length; i++) {
            // 현재 라운드의 적을 우선순위 큐에 추가
            pq.offer(enemy[i]);
            soldiers -= enemy[i];
            
            // 병사가 부족한 경우
            if (soldiers < 0) {
                // 무적권이 남아있는 경우
                if (k > 0) {
                    // 가장 많은 적이 있는 라운드에 무적권 사용
                    soldiers += pq.poll();
                    k--;
                } else {
                    return i;
                }
            }
        }
        
        // 모든 라운드를 클리어한 경우
        return enemy.length;
    }
}