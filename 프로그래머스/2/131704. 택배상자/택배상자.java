import java.util.*;

class Solution {
    public int solution(int[] order) {
        int n = order.length;
        Stack<Integer> stack = new Stack<>();
        
        int answer = 0;
        int idx = 0;
        for(int i=1; i<=n; i++) {
            stack.push(i);
            
            while(!stack.isEmpty() && order[idx] == stack.peek()) {
                answer++;
                idx++;
                stack.pop();
            }
        }
        
        return answer;
    }
}