import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(delete_list);
        for(int i : arr) {
            if(Arrays.binarySearch(delete_list, i) < 0) {
                answer.add(i);
            }
        }
        
        return answer.stream().mapToInt(s->s).toArray();
    }
}