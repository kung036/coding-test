package programmers;

// 조합이 아닌 dp로 문제를 풀어야함
// https://gom20.tistory.com/65

public class Level2_2xn_타일링 {
        public int solution(int n) {
            int[] dp = new int[60001];
            dp[1] = 1;
            dp[2] = 2;

            for(int i=3; i<=n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
                if(dp[i] >= 1000000007) dp[i] %= 1000000007;
            }

            return dp[n];
        }
    }