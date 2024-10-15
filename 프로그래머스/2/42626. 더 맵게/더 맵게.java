import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int sc : scoville) {
            pq.add(sc);
        }
        if(pq.size() == 0) return 1;
        
        int newScoville = 0;
        int answer = 0;
        while(pq.size() > 1 && pq.peek()<K) {
            int min1 = pq.poll();
            int min2 = pq.poll();
            newScoville = min1 + min2*2;
            pq.add(newScoville);
            answer++;
        }
        
        if(pq.peek() < K) answer = -1;
        
        return answer;
    }
}