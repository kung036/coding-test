import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        // e(끝점) 기준 오름차순 정렬
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        int answer = 0;
        long last = Long.MIN_VALUE; // 아직 쏜 적 없음을 의미

        for (int[] t : targets) {
            int s = t[0];
            int e = t[1];
            // 현재 구간이 마지막 요격 지점으로 커버되지 않으면 새로 쏴야 함
            if (s >= last) {
                answer++;
                last = e; // e에 아주 근접한(=e보다 살짝 작은) 지점에서 쐈다고 가정
            }
        }

        return answer;
    }
}