import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        Arrays.sort(lost);
        Set<Integer> set = new HashSet<>();
        set = Arrays.stream(reserve)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new));
        for(int i=0; i<lost.length; i++) {
            int l = lost[i];
            if(set.contains(l)) {
                set.remove(l);
                lost[i] = -1;
                answer++;
            }
        }
        
        for(int l : lost) {
            if(l == -1) continue;
            
            // l-1 또는 l+1이 set에 있으면 수업에 참여할 수 있음
            // set에서 빌린 체육복 제거
            if(set.contains(l-1)) set.remove(l-1);
            else if(set.contains(l+1)) set.remove(l+1);
            else continue;
            answer++;
        }
        
        return answer;
    }
}