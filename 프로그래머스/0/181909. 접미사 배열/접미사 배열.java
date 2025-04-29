import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList<>();
        String str = "";
        int n = my_string.length();
        for(int i=n-1; i>=0; i--) {
            str = my_string.charAt(i) + str;
            list.add(str);
        }
        String[] answer = list.toArray(String[]::new);
        Arrays.sort(answer);
        return answer;
    }
}