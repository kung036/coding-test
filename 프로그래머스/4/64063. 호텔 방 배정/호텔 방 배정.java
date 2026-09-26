import java.util.*;

class Solution {
    private Map<Long, Long> nextFree = new HashMap<>();

    // x번 방부터 비어있는 가장 작은 방 번호를 찾음 (경로 압축 적용, 반복문으로 구현해 스택오버플로 방지)
    private long find(long x) {
        long root = x;
        while (nextFree.containsKey(root)) {
            root = nextFree.get(root);
        }
        // 경로 압축: 지나온 노드들을 모두 root에 직접 연결
        long cur = x;
        while (nextFree.containsKey(cur) && nextFree.get(cur) != root) {
            long next = nextFree.get(cur);
            nextFree.put(cur, root);
            cur = next;
        }
        return root;
    }

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            long want = room_number[i];
            long assigned = find(want);
            answer[i] = assigned;
            nextFree.put(assigned, assigned + 1); // 이 방은 이제 (assigned+1)번을 가리킴
        }

        return answer;
    }
}