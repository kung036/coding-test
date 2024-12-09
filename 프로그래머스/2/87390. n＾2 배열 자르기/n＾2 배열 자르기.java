import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        // n = 3 : 123  223  333
        // n = 4 : 1234 2234 3334 4444
        // 시작 : 1~n
        // 0번째줄 : 1~n
        // i번째줄 : i번째 값(i+1)을 (i-1)번째까지 반복
        // left와 right 구하기 -> left = (left)%n번째줄 left/n번째
        // right 동일
        
        int len = (int)(right-left)+1;
        int[] answer = new int[len];
        int idx = 0; // answer의 index
        int startY = (int)(left/n); // 시작행
        int startX = (int)(left%n); // 시작열

        // 시작 열
        int j = startX;

        // 이중for문을 돌면서 answer값 채우기
        for(int i=startY; i<=right/n; i++) {
            int tmp = i+1;
            for(; j<n; j++) {
                // 종료시점일때
                if(idx == len) break;

                // 0번째 줄일때
                if(i == 0 || tmp <= j) answer[idx++] = j+1;
                else if(j < tmp) answer[idx++] = tmp;
            }
            j=0;
        }
        
        return answer;
    }
}