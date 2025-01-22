import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        // 넓이 구하기
        List<Double> area = new ArrayList<>();
        double sum = 0;
        double next = sum;
        area.add(sum);
        int n = 0;
        
        while(k != 1) {
            if(k%2 == 0) next = k/2;
            else next = k*3 + 1;
            sum += (next+k)/2;
            area.add(sum);
            k = (int)next;
        }
        n = area.size() - 1;
        
        // 정적분 구하기
        int idx = 0;
        for(int[] range : ranges) {
            int a = range[0];
            int b = n + range[1];
            if(b < a) answer[idx++] = -1.0;
            else answer[idx++] = area.get(b) - area.get(a);
        }
        
        return answer;
    }
}