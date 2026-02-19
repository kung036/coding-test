import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i : arr) {
            if(stack.isEmpty()) stack.push(i);
            else if(stack.peek() == i) continue;
            else {
                answer.add(stack.pop());
                stack.push(i);
            }
        }
        if(!stack.isEmpty()) answer.add(stack.pop());
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}