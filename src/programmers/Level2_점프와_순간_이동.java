package programmers;

import java.util.*;

public class Level2_점프와_순간_이동 {
    public int solution(int n) {
        int ans = 0;

        while(n > 0) {
            if(n%2 == 1) ans++;
            n /= 2;
        }
        // 5000
        // 0(+1) -> 1 -> 2 -> 4 -> 8(+1) -> 9 -> 18(+1) -> 19 -> 38(+1) -> 39
        // 78 -> 156 -> 312 -> 624(+1) -> 625 -> 1250 -> 2500 -> 5000

        return ans;
    }
}
