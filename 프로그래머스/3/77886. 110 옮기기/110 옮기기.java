import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = s.clone();
        int idx = 0;
        
        for(String x : s) {
            char[] chars = x.toCharArray();
            ArrayDeque<Character> q = new ArrayDeque<>();
            StringBuilder sb110 = new StringBuilder();
            
            // 110 추출하기
            for(char ch : chars) {
                q.add(ch);
                if(q.size() >= 3) {
                    char c3 = q.pollLast();
                    char c2 = q.pollLast();
                    char c1 = q.pollLast();
                    // System.out.println(""+c1+c2+c3);
                    if((""+c1+c2+c3).equals("110")) sb110.append("110");
                    else {
                        q.offerLast(c1);
                        q.offerLast(c2);
                        q.offerLast(c3);                        
                    }
                }
            }
            
            // 110을 제외한 부분 추출하기
            StringBuilder sb = new StringBuilder();
            while(!q.isEmpty()) {
                sb.append(q.poll());
            }
            
            // 적절한 위치에 110 넣기
            if(sb.indexOf("11") != -1) {
                sb.insert(sb.indexOf("11"), sb110);
            } else if(sb.lastIndexOf("0") != -1) {
                sb.insert(sb.lastIndexOf("0")+1, sb110);
            } else {
                sb.insert(0, sb110);
            }
            
            answer[idx++] = sb.toString();
        }
        
        return answer;
    }
}