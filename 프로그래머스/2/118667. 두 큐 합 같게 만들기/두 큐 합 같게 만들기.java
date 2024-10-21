import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 원소 합을 같게 만들 수 없는 횟수
        int max = queue1.length + queue2.length;
        int answer = 0;
        
        // 큐
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0; i<queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        while(answer<=max+1) {
            if(sum1 == sum2) break;
            
            if(sum1 > sum2) {
                int tmp = q1.poll();
                q2.add(tmp);
                sum1 -= tmp;
                sum2 += tmp;
            } else {
                int tmp = q2.poll();
                q1.add(tmp);
                sum2 -= tmp;
                sum1 += tmp;
            }
            answer++;
        }
        
        // 두 큐의 합이 같지 않은 경우
        if(sum1 != sum2) answer = -1;
        
        return answer;
    }
}