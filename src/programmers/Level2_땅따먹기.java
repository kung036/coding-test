package programmers;
import java.util.*;

// 참고 사이트 : https://ilmiodiario.tistory.com/88

public class Level2_땅따먹기 {
    class Solution {
        int solution(int[][] land) {
            int max = 0; // 최고점

            // DP
            for(int i=1; i<land.length; i++) {
                int a = land[i-1][0];
                int b = land[i-1][1];
                int c = land[i-1][2];
                int d = land[i-1][3];

                land[i][0] += Math.max(b, Math.max(c, d));
                land[i][1] += Math.max(a, Math.max(c, d));
                land[i][2] += Math.max(a, Math.max(b, d));
                land[i][3] += Math.max(a, Math.max(b, c));
            }

            int[] last = land[land.length-1];
            max = Math.max(Math.max(last[0], last[1]), Math.max(last[2], last[3]));

            return max;
        }
    }
}
