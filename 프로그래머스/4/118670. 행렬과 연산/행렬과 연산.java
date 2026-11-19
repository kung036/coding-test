import java.util.*;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int r = rc.length, c = rc[0].length;

        Deque<Integer> left = new ArrayDeque<>();           // 왼쪽 열
        Deque<Integer> right = new ArrayDeque<>();          // 오른쪽 열
        Deque<Deque<Integer>> mid = new ArrayDeque<>();     // 각 행의 안쪽(1 ~ c-2열)

        for (int i = 0; i < r; i++) {
            left.addLast(rc[i][0]);
            right.addLast(rc[i][c - 1]);
            Deque<Integer> row = new ArrayDeque<>();
            for (int j = 1; j < c - 1; j++) row.addLast(rc[i][j]);
            mid.addLast(row);
        }

        for (String op : operations) {
            if (op.charAt(0) == 'S') {              // ShiftRow
                left.addFirst(left.pollLast());
                right.addFirst(right.pollLast());
                mid.addFirst(mid.pollLast());
            } else {                                // Rotate
                mid.peekFirst().addFirst(left.pollFirst());
                right.addFirst(mid.peekFirst().pollLast());
                mid.peekLast().addLast(right.pollLast());
                left.addLast(mid.peekLast().pollFirst());
            }
        }

        int[][] answer = new int[r][c];
        for (int i = 0; i < r; i++) {
            answer[i][0] = left.pollFirst();
            Deque<Integer> row = mid.pollFirst();
            for (int j = 1; j < c - 1; j++) answer[i][j] = row.pollFirst();
            answer[i][c - 1] = right.pollFirst();
        }
        return answer;
    }
}