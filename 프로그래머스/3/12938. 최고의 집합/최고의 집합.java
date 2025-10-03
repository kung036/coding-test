import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};

        int q = s / n;
        int r = s % n;

        int[] answer = new int[n];
        Arrays.fill(answer, q);
        for(int i = n - 1; i >= n - r; i--) {
            answer[i]++;
        }
        return answer;
    }
}
