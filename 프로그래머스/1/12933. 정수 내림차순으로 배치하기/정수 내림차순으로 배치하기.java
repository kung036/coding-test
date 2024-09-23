import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        List<Integer> list = new ArrayList<>();
        
        while(n > 0) {
            list.add((int)(n%10));
            n/=10;
        }
        int[] sort = list.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
        
        long tmp = 1;
        for(int i : sort) {
            answer += i * tmp;
            tmp*=10;
        }
        
        return answer;
    }
}