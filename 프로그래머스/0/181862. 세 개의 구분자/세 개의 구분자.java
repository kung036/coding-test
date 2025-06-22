import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = Arrays.stream(myStr.replaceAll("[abc]+", " ").split(" "))
            .filter(s -> !s.isEmpty())
            .toArray(String[]::new);
        if(answer.length == 0) answer = new String[]{"EMPTY"};
        return answer;
    }
}