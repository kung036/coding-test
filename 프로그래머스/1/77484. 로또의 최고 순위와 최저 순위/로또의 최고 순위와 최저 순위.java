import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 1. 구매한 로또 번호를 오름차순으로 정렬        
        Arrays.sort(win_nums);
        
        // 2. 로또 번호를 set에 넣음
        Set<Integer> lottoSet = Arrays.stream(win_nums)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new));
        
        // 3. 0을 제외한 로또 번호 중에서 set에 있는 개수 구하기 -> 최소 등수
        int[] answer = new int[]{0,0};
        for(int i : lottos) {
            if(i==0) answer[0]++;
            else if(lottoSet.contains(i)) answer[1]++;
        }
        
        // 4. 0의 개수만큼 전부 맞춤 -> 최대 등수
        answer[0] += answer[1];
        
        // 5. 맞춘 개수에 따라서 등수 구하기
        for(int i=0; i<2; i++) {
            int cnt = answer[i];
            if(cnt==6) answer[i] = 1;
            else if(cnt==5) answer[i] = 2;
            else if(cnt==4) answer[i] = 3;
            else if(cnt==3) answer[i] = 4;
            else if(cnt==2) answer[i] = 5;
            else answer[i] = 6;
        }
        
        return answer;
    }
}