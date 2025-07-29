import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        
        while(answer.size() < k) {
            if(idx >= arr.length) answer.add(-1);
            else if(!answer.contains(arr[idx])) answer.add(arr[idx]);
            idx++;
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}