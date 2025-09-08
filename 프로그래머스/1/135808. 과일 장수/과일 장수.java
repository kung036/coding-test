import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        // 사과 점수를 내림차순 정렬
        Arrays.sort(score);
        int n = score.length;
        
        // 뒤에서부터 m개씩 묶어서 상자 포장
        for (int i = n - m; i >= 0; i -= m) {
            // 현재 묶음(m개)의 가장 낮은 점수 (정렬했으므로 맨 앞이 최저)
            int min = score[i];
            answer += min * m;
        }
        return answer;
    }
}
