import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        
        for(int i=0; i<enemy.length; i++) {
            q.add(enemy[i]);
            n -= enemy[i];
            
            // 남은 병사가 없는 경우
            if(n < 0) {
                if(k == 0) return i; // 남은 무적권이 없는 경우
                else { // 무적권이 남은 경우
                    k--;
                    n += q.poll();
                }
            }
        }        
        
        return enemy.length;
    }
}