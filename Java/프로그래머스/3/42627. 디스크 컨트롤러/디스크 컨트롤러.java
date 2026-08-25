import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        // [요청시각, 소요시간, 원래 인덱스]로 정렬 (요청시각 기준)
        int[][] sortedJobs = jobs.clone();
        Arrays.sort(sortedJobs, (a, b) -> a[0] - b[0]);

        // 대기 큐: 소요시간 짧은 순 -> 요청시각 빠른 순
        PriorityQueue<int[]> waitQueue = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1]; // 소요시간
            return a[0] - b[0]; // 요청시각
        });

        int idx = 0; // sortedJobs에서 아직 큐에 안 들어간 작업 포인터
        long currentTime = 0;
        long totalTurnaround = 0;
        int processed = 0;

        while (processed < n) {
            // 현재 시각까지 도착한 작업들을 전부 대기 큐에 넣기
            while (idx < n && sortedJobs[idx][0] <= currentTime) {
                waitQueue.offer(sortedJobs[idx]);
                idx++;
            }

            if (waitQueue.isEmpty()) {
                // 처리할 작업이 없으면 다음 작업 도착 시각으로 점프
                currentTime = sortedJobs[idx][0];
                continue;
            }

            int[] job = waitQueue.poll();
            currentTime += job[1]; // 작업 수행
            totalTurnaround += (currentTime - job[0]); // 반환시간 = 종료시각 - 요청시각
            processed++;
        }

        return (int) (totalTurnaround / n);
    }
}