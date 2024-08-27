import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // stack 이용
        Stack<String> stack = new Stack<>();
        
        // s를 쪼개서 한 문자씩 순회
        // 이때 (면 push하고 )이면 pop 연산
        // 순회 후 stack의 size가 0이면 true 반환, 아니면 false 반환
        
        for(int i=0; i<s.length(); i++) {
            Character cur = s.charAt(i);
            
            if(cur == '(') stack.push("(");
            else if(stack.isEmpty()) {
                answer = false;
                break;
            } else { // )인 경우
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}