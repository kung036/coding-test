import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        Character[] ch = sb.append(s).chars()
                                .mapToObj(c -> (char)c)
                                .sorted((o1, o2) -> Integer.compare(o2, o1))
                                .toArray(Character[]::new);
        for(Character c : ch) {
            answer += c;
        }
        
        return answer;
    }
}