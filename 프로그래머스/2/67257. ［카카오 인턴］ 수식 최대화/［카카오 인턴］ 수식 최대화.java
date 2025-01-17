import java.util.*;

class Solution {
    public long solution(String expression) {
        // 1. 연산자 목록 생성 부분은 그대로 유지
        List<String> e = new ArrayList<>(); 
        if(expression.contains("*")) e.add("*");
        if(expression.contains("+")) e.add("+");
        if(expression.contains("-")) e.add("-");
        int n = e.size();

        // 2. 숫자와 연산자 분리
        List<String> tokens = new ArrayList<>();
        StringBuilder num = new StringBuilder();

        for(char c : expression.toCharArray()) {
            if(c == '*' || c == '+' || c == '-') {
                tokens.add(num.toString());
                tokens.add(String.valueOf(c));
                num = new StringBuilder();
            } else {
                num.append(c);
            }
        }
        tokens.add(num.toString());

        // 3. 연산자 우선순위 조합 생성
        List<String> priorities = new ArrayList<>();
        if(n == 1) {
            priorities.add(e.get(0));
        } else if(n == 2) {
            priorities.add(e.get(0) + e.get(1));
            priorities.add(e.get(1) + e.get(0));
        } else if(n == 3) {
            priorities.add("*+-");
            priorities.add("*-+");
            priorities.add("+*-");
            priorities.add("+-*");
            priorities.add("-*+");
            priorities.add("-+*");
        }

        // 4. 각 우선순위별로 계산
        long maxResult = 0;

        for(String priority : priorities) {
            List<String> tmpTokens = new ArrayList<>(tokens);

            for(char op : priority.toCharArray()) {
                for(int i = 0; i < tmpTokens.size(); i++) {
                    if(tmpTokens.get(i).equals(String.valueOf(op))) {
                        long result = calculate(
                            Long.parseLong(tmpTokens.get(i-1)), 
                            Long.parseLong(tmpTokens.get(i+1)), 
                            op
                        );
                        tmpTokens.set(i-1, String.valueOf(result));
                        tmpTokens.remove(i);
                        tmpTokens.remove(i);
                        i--;
                    }
                }
            }
            maxResult = Math.max(maxResult, Math.abs(Long.parseLong(tmpTokens.get(0))));
        }

        return maxResult;
    }

    private long calculate(long a, long b, char op) {
        switch(op) {
            case '*': return a * b;
            case '+': return a + b;
            case '-': return a - b;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
}