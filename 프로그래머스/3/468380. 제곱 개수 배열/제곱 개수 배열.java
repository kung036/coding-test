import java.util.*;

class Solution {
    int n;
    long[] P, S;   // P[i]: 앞 i개 블록의 길이 합, S[i]: 앞 i개 블록의 원소 합
    int[] a;

    // brr[1..x]의 합
    long F(long x) {
        if (x <= 0) return 0;
        int b = block(x);
        return S[b - 1] + (long) a[b - 1] * (x - P[b - 1]);
    }

    // brr[x]가 속한 블록 번호 (1-indexed)
    int block(long x) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (P[mid] >= x) hi = mid; else lo = mid + 1;
        }
        return lo;
    }

    public long[] solution(int[] arr, long l, long r) {
        a = arr; n = arr.length;
        P = new long[n + 1]; S = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            P[i] = P[i - 1] + arr[i - 1];
            S[i] = S[i - 1] + (long) arr[i - 1] * arr[i - 1];
        }
        long M = P[n];
        long K = F(r) - F(l - 1);
        long L = r - l + 1;
        long last = M - L + 1;             // 창 시작 위치의 마지막 값

        // 창 시작 s를 움직일 때 기울기가 바뀌는 지점들
        TreeSet<Long> bp = new TreeSet<>();
        bp.add(1L);
        for (int b = 0; b <= n; b++) {
            long s1 = P[b] + 1;            // brr[s]의 블록이 바뀜
            long s2 = P[b] - L + 1;        // brr[s+L]의 블록이 바뀜
            if (s1 >= 1 && s1 <= last) bp.add(s1);
            if (s2 >= 1 && s2 <= last) bp.add(s2);
        }
        Long[] pts = bp.toArray(new Long[0]);

        long count = 0;
        for (int i = 0; i < pts.length; i++) {
            long s0 = pts[i];
            long end = (i + 1 < pts.length ? pts[i + 1] - 1 : last);
            long len = end - s0 + 1;
            long f0 = F(s0 + L - 1) - F(s0 - 1);
            if (len == 1) { if (f0 == K) count++; continue; }
            long d = val(s0 + L) - val(s0);
            if (d == 0) {
                if (f0 == K) count += len;
            } else {
                long diff = K - f0;
                if (diff % d == 0) {
                    long t = diff / d;
                    if (t >= 0 && t < len) count++;
                }
            }
        }
        return new long[]{K, count};
    }

    long val(long x) { return a[block(x) - 1]; }
}