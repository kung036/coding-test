import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        long sum = 0;
        for (int t : food_times) sum += t;
        if (sum <= k) return -1; // 다 먹고도 남는 시간이면 먹을 게 없음

        // {소요시간, 음식번호} 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new int[]{food_times[i], i + 1});
        }

        long prev = 0;                 // 지금까지 완전히 먹은 시간(라운드 수)
        long remain = food_times.length; // 남은 음식 개수

        while (!pq.isEmpty()) {
            long cost = (pq.peek()[0] - prev) * remain; // 가장 적은 음식 다 먹는 데 드는 시간
            if (cost > k) break;
            k -= cost;
            prev = pq.poll()[0];
            remain--;
        }

        // 남은 음식들을 번호순으로 정렬 후 k번째 위치
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) list.add(pq.poll()[1]);
        Collections.sort(list);

        return list.get((int) (k % remain));
    }
}