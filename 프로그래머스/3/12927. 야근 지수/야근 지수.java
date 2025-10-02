import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        // 작업량을 N시간 안에 끝낼 수 있는 경우
        long sum = Arrays.stream(works).sum();
        if(sum <= n) return 0;
        
        Arrays.stream(works).forEach(q::add);
        while(n > 0) {
            int tmp = q.poll();
            if(--tmp != 0) q.add(tmp);
            n--;
        }
        
        long answer = q.stream().mapToLong(o -> o*o).sum();
        
        return answer;
    }
}