import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        Arrays.fill(answer, -1); // 기본값으로 -1 채우기
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int idx = stack.pop();
                answer[idx] = numbers[i];
            }
            stack.push(i);
        }
        
        return answer;
    }
}
