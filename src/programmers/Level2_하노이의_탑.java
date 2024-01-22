package programmers;

import java.util.*;

class Level2_하노이의_탑 {
    List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        int[][] answer = {};

        // 재귀이용
        recursive(n, 1, 3);
        answer = list.toArray(new int[0][]);

        return answer;
    }

    // n개의 원판 이동, 출발지 from, 목적지 to
    public void recursive(int n, int from, int to) {
        // 1개가 남으면 바로 목적지로 이동
        if(n == 1) {
            list.add(new int[]{from, to});
        } else if(n > 1) { // 2개 이상이면
            // N-1가 출발지에서 보류지로 이동 -> 크기 N이 목적지로 이동 -> N-1가 보류지에서 목적지로 이동
            recursive(n-1, from, 6-from-to);
            list.add(new int[]{from, to});
            recursive(n-1, 6-from-to, to);
        }
    }
}