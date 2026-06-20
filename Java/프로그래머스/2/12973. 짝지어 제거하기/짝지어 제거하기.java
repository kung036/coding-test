import java.util.*;

public class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && ch == stack.peek()) stack.pop();
            else stack.push(ch);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}