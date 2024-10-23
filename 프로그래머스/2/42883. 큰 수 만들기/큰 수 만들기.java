import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // a[i-1] < a[i] -> a[i-1] 제거
        
        char[] ch = number.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(char c : ch) {
            stack.push(c);
            
            while(stack.size() >= 2 && k > 0) {
                char n2 = stack.pop();
                char n1 = stack.pop();
                if(n1 < n2) {
                    stack.push(n2);
                    k--;
                } else {
                    stack.push(n1);
                    stack.push(n2);
                    break;
                }
            }
        }
        
        while(k>0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}