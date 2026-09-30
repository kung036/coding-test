import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String bin = Long.toBinaryString(numbers[i]);

            // 포화 이진트리 길이(2^k - 1)가 될 때까지 앞에 0(더미 노드) 채우기
            int size = 1;
            while (size < bin.length()) size = size * 2 + 1;
            bin = "0".repeat(size - bin.length()) + bin;

            answer[i] = check(bin, 0, bin.length() - 1) ? 1 : 0;
        }
        return answer;
    }

    private boolean check(String s, int l, int r) {
        int mid = (l + r) / 2;

        // 루트가 더미(0)면 서브트리 전체가 0이어야 함
        if (s.charAt(mid) == '0') {
            for (int i = l; i <= r; i++) {
                if (s.charAt(i) == '1') return false;
            }
            return true;
        }

        if (l == r) return true;
        return check(s, l, mid - 1) && check(s, mid + 1, r);
    }
}