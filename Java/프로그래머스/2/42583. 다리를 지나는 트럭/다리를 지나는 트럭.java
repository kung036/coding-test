import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge = new ArrayDeque<>();
        int time = 0;
        int sum = 0;
        int idx = 0;

        while (idx < truck_weights.length || !bridge.isEmpty()) {
            time++;

            if (!bridge.isEmpty() && bridge.peek()[1] == time) {
                sum -= bridge.poll()[0];
            }

            if (idx < truck_weights.length && sum + truck_weights[idx] <= weight) {
                sum += truck_weights[idx];
                bridge.add(new int[]{truck_weights[idx], time + bridge_length});
                idx++;
            }
        }

        return time;
    }
}