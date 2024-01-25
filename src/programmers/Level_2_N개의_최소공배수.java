package programmers;
import java.util.*;

// 유클리드 호제법을 이용한 최소공배수 구하기

public class Level_2_N개의_최소공배수 {
    public int solution(int[] arr) {
        Arrays.sort(arr); // 오름차순 정렬
        int answer = arr[0]; // 최소공배수

        for(int i=1; i<arr.length; i++) {
            int a = Math.max(answer, arr[i]);
            int b = Math.min(answer, arr[i]);
            answer = (a*b) / gcd(a, b);
        }

        return answer;
    }

    // 최소공배수 구하기(a > b)
    public int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a%b);
    }
}