package programmers;
import java.util.*;

// stack 이용
// 9, 11, 12 -> 런타임 에러
// 2, 4, 5, 6, 7 -> 효율성 테스트 실패

public class Level2_짝지어_제거하기 {
    public int solution(String s) {
        int answer = 0;

        Stack<String> stack = new Stack<>();

        List<String> list = new ArrayList<>();
        Collections.addAll(list, s.split(""));
        int last = list.size();

        int index = 0;

        while(index < last) {
            System.out.println(index + " " + last);
            System.out.println(stack.toString());
            if(stack.isEmpty()) stack.push(list.get(index++));

            String before = stack.peek();
            stack.push(list.get(index++));
            String after = stack.peek();

            System.out.println("후1 : " + stack.toString());

            // 같은 문자인 경우
            if(before.equals(after)) {
                stack.pop();
                stack.pop();
            }

            System.out.println("후2 : " + stack.toString());

            while(stack.size() >= 2 && before.equals(after)) {
                before = stack.pop();
                after = stack.peek();

                if(before.equals(after)) { // 같은 문자인 경우
                    stack.pop();
                } else { // 다른 문자인 경우
                    stack.push(before);
                    break;
                }
            }
        }

        if(stack.isEmpty()) answer = 1;

        return answer;
    }
}
