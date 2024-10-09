import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        // DP 배열 선언 및 초기화
        Set<Integer>[] dp = new HashSet[9];
        
        // DP 배열 초기화
        for (int i = 1; i < 9; i++) {
            dp[i] = new HashSet<>();
            int repeatedNum = Integer.parseInt(String.valueOf(N).repeat(i));
            dp[i].add(repeatedNum);
        }
        
        // DP 계산
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int x : dp[j]) {
                    for (int y : dp[i - j]) {
                        dp[i].add(x + y);
                        dp[i].add(x - y);
                        dp[i].add(x * y);
                        if (y != 0) dp[i].add(x / y);
                    }
                }
            }
            // 목표 숫자가 dp[i]에 있으면 i 반환
            if (dp[i].contains(number)) {
                return i;
            }
        }
        
        return -1; // 목표 숫자를 8번 안에 만들 수 없는 경우
    }
}
