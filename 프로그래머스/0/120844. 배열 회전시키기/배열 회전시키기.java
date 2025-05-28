import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int d = direction.equals("right") ? -1 : 1;
        int n = numbers.length;
        return IntStream.range(0, n).map(i -> numbers[(n+i+d)%n]).toArray();
    }
}