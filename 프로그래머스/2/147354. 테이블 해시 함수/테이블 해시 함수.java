import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col-1] == o2[col-1]) return Integer.compare(o2[0], o1[0]);
            return Integer.compare(o1[col-1], o2[col-1]);
        });
        
        int answer = 0;
        for(int i=row_begin; i<=row_end; i++) {
            int sum = 0;
            for(int n : data[i-1]) {
                sum += n % i;
            }
            answer ^= sum;
        }
        
        return answer;
    }
}