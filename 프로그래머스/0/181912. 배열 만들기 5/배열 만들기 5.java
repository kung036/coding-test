import java.util.stream.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        return IntStream.range(0, intStrs.length)
                        .map(i -> Integer.valueOf(intStrs[i].substring(s, s+l)))
                        .filter(o -> k < o)
                        .toArray();
    }
}