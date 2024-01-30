package programmers;
import java.util.*;

// stack 이용
// 참고 사이트 : https://velog.io/@dhk22/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A7%9D%EC%A7%80%EC%96%B4-%EC%A0%9C%EA%B1%B0%ED%95%98%EA%B8%B0-Java

public class Level2_짝지어_제거하기 {
    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);

            if(stack.isEmpty()) stack.push(c);
            else {
                if(stack.peek() == c) stack.pop();
                else stack.push(c);
            }
        }

        if(stack.isEmpty()) answer = 1;

        return answer;
    }
}
