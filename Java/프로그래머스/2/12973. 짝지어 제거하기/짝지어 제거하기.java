import java.util.*;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // stack 구현
        // s를 문자단위로 쪼개서 stack에 하나씩 넣음
        // 이때 stack에 가장 최근에 들어온 것과 같이 같으면 pop하기
        // stack이 비어있으면 1 반환, 아니면 0 반환
        
        Stack<Character> stack = new Stack<>();
        
        for(Character ch : s.toCharArray()) {
            if(!stack.isEmpty() && ch == stack.peek()) stack.pop();
            else stack.push(ch);
        }
        
        if(stack.isEmpty()) answer = 1;

        return answer;
    }
}