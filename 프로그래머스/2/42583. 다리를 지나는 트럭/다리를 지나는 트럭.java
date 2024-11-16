import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 큐를 이용해서 트럭무게 넣기
        Queue<Integer> queue = new ArrayDeque<>();
        int time = 0; // 경과 시간

        int sum = 0; // 도로 위에 올라간 트럭의 총무게
        int next = 0; // 다음 트럭의 인덱스
        int n = truck_weights.length; // 트럭 개수
        
        while(next<n || !queue.isEmpty()) {
            time++; // 시간 경과
            
            // 시간이 지나서 트럭이 도로를 나감
            if(queue.size() >= bridge_length) {
                sum -= queue.poll();
            }
            
            // 다음 트럭이 다리를 건널 수 있는 경우
            if(next < n && sum+truck_weights[next]<=weight) {
                queue.add(truck_weights[next]);
                sum += truck_weights[next++];
            } else {
                queue.add(0);
            }
            
            if(sum == 0) break;
        }

        return time;
    }
}