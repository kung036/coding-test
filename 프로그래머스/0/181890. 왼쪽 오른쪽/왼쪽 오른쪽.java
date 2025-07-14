import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<str_list.length; i++) {
            String s = str_list[i];
            if(s.equals("l")) {
                answer = list.toArray(new String[0]);
                break;
            } else if(s.equals("r")) {
                answer = Arrays.copyOfRange(str_list, i+1, str_list.length);
                break;
            }
            list.add(s);
        }
        
        return answer;
    }
}