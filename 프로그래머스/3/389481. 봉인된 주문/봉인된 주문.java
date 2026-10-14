import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        // 삭제된 주문을 "주문서에서의 순번"으로 변환
        long[] ranks = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            long r = 0;
            for (char c : bans[i].toCharArray()) {
                r = r * 26 + (c - 'a' + 1);
            }
            ranks[i] = r;
        }
        Arrays.sort(ranks);

        // 순번 작은 것부터 보면서, n 이하면 한 칸씩 밀기
        for (long r : ranks) {
            if (r <= n) n++;
            else break;
        }

        // 순번 n -> 문자열 (a=1 ... z=26인 26진법)
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) ('a' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}