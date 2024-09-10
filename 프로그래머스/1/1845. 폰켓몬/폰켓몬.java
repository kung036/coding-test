import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // nums를 set으로 변경
        // set의 길이가 nums/2 길이보다 작거나 set의 길이 반환
        // nums/2 길이 반환
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        
        int answer = 0;
        if(set.size() < nums.length/2) answer = set.size();
        else answer = nums.length/2;
        
        return answer;
    }
}