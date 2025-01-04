import java.util.*;

class Solution {
    public String solution(String p) {
        // () 짝이 맞음 -> 균형잡힌 괄호 문자열 -> 올바른 괄호 문자열
        // 변환 과정)
        // 1. w(균형잡힌 괄호 문자열) = u(균형잡힌 괄호 문자열) + v(빈 문자열일 수 있음)
            // u는 최소한의 단위
        // 2. u가 올바른 괄호 문자열이면 v을 대상으로 반복 -> u 뒤에 v 붙임
        // 3. u가 올바른 괄호 문자열이 아니라면 "(" + v 결과 +")" + (u의 첫과 마지막 문자 제거 후 괄호 방향 뒤집기)
        
        return dfs(p);
    }
    
    public String dfs(String p) {
        // 빈 문자열인 경우
        if(p == "") return "";
        
        // u 구하기
        int open = 0;
        int close = 0;
        for(int i=0;i<p.length(); i++) {
            if(p.charAt(i) == '(') open++;
            else close++;
            if(open == close) break;
        }
        String u = p.length() == (open+close) ? p : p.substring(0, open+close);
        
        // v 구하기
        String v = p.length() == (open+close) ? "" : p.substring(open+close, p.length());
        // System.out.println(u + " " + v);
        
        // u의 "올바른 괄호 문자열" 여부 확인
        String w = "";
        if(check(u)) { // "올바른 괄호 문자열"인 경우
            w = u + dfs(v);
        } else { // "올바른 괄호 문자열"가 아닌 경우
            v = dfs(v);
            String reverseU = "";
            for(int i=1; i<u.length()-1; i++) {
                if(u.charAt(i) == '(') reverseU += ")";
                else reverseU += "(";
            }
            
            w = "(" + v + ")" + reverseU;
        }
        
        return w;
    }
    
    public boolean check(String s) {
        if(s.charAt(0) == ')') return false;
        
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        
        for(int i=1; i<s.length(); i++) {
            if(stack.peek() != s.charAt(i)) stack.pop();
            else stack.push(s.charAt(i));
        }
        
        boolean result = false;
        if(stack.isEmpty()) result = true;
        
        // System.out.println(s + " " + result);
        return result;
    }
}