import java.util.*;

class Solution {
    public int solution(int order) {
        return (int) Arrays.stream(String.valueOf(order).split(""))
                    .filter(s -> s.equals("3") || s.equals("6") || s.equals("9"))
                    .count();
    }
}