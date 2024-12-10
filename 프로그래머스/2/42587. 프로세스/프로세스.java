import java.util.*;

class Solution {
    class Node {
        int idx;
        int priority;
        
        Node(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        // 우선순위가 높은 값부터 넣음
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o2, o1)
        );
        
        // Node 큐 선언
        Queue<Node> queue = new ArrayDeque<>();
        
        // 두 개의 큐 정의
        int n = priorities.length;
        for(int i=0; i<n; i++) {
            pq.add(priorities[i]);
            queue.add(new Node(i, priorities[i]));
        }
        
        int answer = 0;
        while(true) {
            Node now = queue.peek();
                        
            // 가장 큰 우선순위일 경우
            if(now.priority == pq.peek()) { // 프로세스 진행
                answer++;
                // 큐의 idx가 location일 때 종료
                if(now.idx == location) break;

                pq.poll();
                queue.poll();
            } else { // 프로세스를 진행하지 못한 경우
                queue.add(queue.poll());
            }
        }
        
        return answer;
    }
}