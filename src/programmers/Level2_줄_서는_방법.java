package programmers;
import java.util.*;

// 참고 사이트
// https://gogoma.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A4%84-%EC%84%9C%EB%8A%94-%EB%B0%A9%EB%B2%95-JAVA

class Level2_줄_서는_방법 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long all = 1;

        for(int i=1; i<=n; i++) {
            all *= i;
            list.add(i);
        }

        int i = 0;

        k--;
        while(i<n) {
            all /= n-i;
            // System.out.println(k + " " + current + " " + (int)(k/current));
            answer[i++] = list.remove((int)(k/all));
            k%=all;
        }

        return answer;
    }
}