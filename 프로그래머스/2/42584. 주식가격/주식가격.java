import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        // stack에 prices의 index를 순서대로 넣음
        // index의 값이 peek의 값보다 작으면 stack의 값보다 같거나 작을 때까지 빼기
        // 빼면서 count값을 올리면서 넣기
        
        for(int i=0; i<prices.length-1; i++) {
            int price = prices[i];
            if(stack.isEmpty() || price >= prices[stack.peek()]) stack.push(i);
            else { // 1 6 9 5
                while(true) {
                    if(stack.isEmpty() || price >= prices[stack.peek()]) break;
                    
                    int index = stack.pop();
                    answer[index] = i - index;
                }
                stack.push(i);
            }
        }
        
        while(!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - index - 1;
        }
        
        return answer;
    }
}