import java.util.stream.*;

class Solution {
    public int solution(int n) {
        return (int) IntStream.rangeClosed(1, n)
                .filter(start -> {
                    int sum = 0;
                    for (int x = start; sum < n; x++) {
                        sum += x;
                        if (sum == n) return true;
                    }
                    return false;
                })
                .count();
    }
}