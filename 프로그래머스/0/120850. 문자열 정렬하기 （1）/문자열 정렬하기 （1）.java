import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        for(int i : my_string.toCharArray()) {
            if(48 <= i && i <= 57) list.add(i-48);
        }
        
        int[] answer = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
}