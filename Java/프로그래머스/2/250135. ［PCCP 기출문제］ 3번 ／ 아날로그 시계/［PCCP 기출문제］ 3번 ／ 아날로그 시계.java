class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        long T1 = h1 * 3600L + m1 * 60L + s1;
        long T2 = h2 * 3600L + m2 * 60L + s2;

        long countHour   = countInRange(T1, T2, 719, 43200); // t = k*43200/719
        long countMinute = countInRange(T1, T2, 59, 3600);   // t = k*3600/59
        long countTriple = countInRange(T1, T2, 1, 43200);   // t = k*43200

        return (int) (countHour + countMinute - countTriple);
    }

    // t_k = k * denom / num 형태의 시각들 중 [T1, T2]에 포함되는 정수 k의 개수
    // 조건: T1 <= k*denom/num <= T2  <=>  T1*num <= k*denom <= T2*num
    private long countInRange(long T1, long T2, long num, long denom) {
        long lowerK = ceilDiv(T1 * num, denom);
        long upperK = Math.floorDiv(T2 * num, denom);
        return Math.max(upperK - lowerK + 1, 0);
    }

    private long ceilDiv(long a, long b) {
        return Math.floorDiv(a + b - 1, b);
    }
}