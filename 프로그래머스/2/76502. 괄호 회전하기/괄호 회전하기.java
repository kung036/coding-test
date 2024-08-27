import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        // s를 한문자씩 List로 바꾸기
        // 괄호가 유효한지 회전한 s를 순회하면서 확인
        // 여는 괄호는 push하고, 닫는 괄호는 pop하기
        // 이때 닫는 괄호가 왔을 때, stack에 여는 괄호가 없는 경우 또는 stack이 비어있는 경우에는 유효하지 않은 괄호 -> break
        // 무사히 순회한 경우에는 유효한 괄호
        // s의 길이만큼 회전시키기 (0 ~ (s의길이-1))
        // -> 순회하고 있는 값을 마지막으로 이동시키기
        // -> 이때 이동시킨 값은 ""로 표현

        String[] list = new String[s.length() * 2];
        String[] split = s.split("");
        for(int i=0; i<split.length; i++)
            list[i] = split[i];
        int idx = s.length();

        for(int i=0; i<s.length(); i++) {
            Stack<String> stack = new Stack<>();
            int listSize = list.length;
            for(int j=0; j<idx; j++) {
                String cur = list[j];
                if(cur.equals("")) continue;

                if(cur.equals("(")) stack.push("("); // 여는 괄호
                else if(cur.equals("[")) stack.push("[");
                else if(cur.equals("{")) stack.push("{");
                else if(stack.isEmpty()) break; // stack이 없는데 닫는 괄호가 온 경우
                else { // 닫는 괄호
                    String peek = stack.peek();
                    if(cur.equals(")") && peek.equals("(")) stack.pop();
                    else if(cur.equals("]") && peek.equals("[")) stack.pop();
                    else if(cur.equals("}") && peek.equals("{")) stack.pop();
                    else break; // stack에 여는 괄호가 없는 경우
                }

                // 무사히 순회한 경우
                if(j == idx-1 && stack.isEmpty()) answer++;
            }

            list[idx++] = list[i];
            list[i] = "";
        }

        return answer;
    }
}