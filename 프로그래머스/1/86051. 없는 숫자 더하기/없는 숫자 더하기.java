import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Set<Integer> set = Arrays.stream(numbers)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new));
        
        for(int i=0; i<10; i++) {
            if(!set.contains(i)) answer += i;
        }
        
        return answer;
    }
}