import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 각 작업에 대한 작업 종료 날짜 구하기
        // 계산 방법 : (100-progress) /speed 높임 -> O(N)
        // 배포하는 작업일보다 같거나 작은 작업일 개수 카운팅

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<progresses.length; i++) {
            int finishDay = (int) Math.ceil( (100 - progresses[i]) / (double) speeds[i]);
            queue.add(finishDay);
        }
        
        int day = queue.poll();
        int count = 1;
        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            int nextDay = queue.poll();
            if(day >= nextDay) count++;
            else {
                answer.add(count);
                day = nextDay;
                count = 1;
            }
        }
        answer.add(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}