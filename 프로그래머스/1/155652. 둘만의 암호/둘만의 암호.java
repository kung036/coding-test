import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int cnt = 0;
            char c = ch;
            while(cnt < index) {
                c++;
                if(c > 'z') c -= 26;
                if(skip.indexOf(c) != -1) continue; // skip 문자면 건너뜀
                cnt++;
            }
            answer.append(c);
        }
        return answer.toString();
    }
}