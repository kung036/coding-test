import java.util.*;

public class Solution {
    public int solution(int n) {
        // K 사용량 건전지 : K칸 점프
        // 순간이동 : (현재까지 온 거리) X 2
        
        int ans = 0;
        
        while(n >= 1) {
            if(n%2 == 1) ans++;
            n /= 2;
        }

        return ans;
    }
}