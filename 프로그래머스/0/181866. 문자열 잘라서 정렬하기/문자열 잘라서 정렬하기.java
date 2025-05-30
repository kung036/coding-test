import java.util.*;

class Solution {
    public String[] solution(String myString) {
        List<String> answer = new ArrayList<>();
        String s = "";
        for(char c : myString.toCharArray()) {
            if(c != 'x') s += c;
            else if(!s.equals("")) {
                answer.add(s);
                s = "";
            }
        }
        if(!s.equals("")) answer.add(s);
        
        String[] strs = answer.toArray(String[]::new);
        Arrays.sort(strs);
        return strs;
    }
}