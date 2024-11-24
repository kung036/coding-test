import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        // array에 값을 넣어서 k번 poll한 값 반환하기
        int n = score.length;
        Integer[] rank = new Integer[n];
        int[] answer = new int[n];
        Arrays.fill(rank, -1);
        
        for(int i=0; i<n; i++) {
            rank[i] = score[i];
            Arrays.sort(rank, Collections.reverseOrder());

            if(i<k) answer[i] = rank[i];
            else answer[i] = rank[k-1];
        }
                
        return answer;
    }
}