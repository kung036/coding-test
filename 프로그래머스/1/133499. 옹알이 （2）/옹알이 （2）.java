import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        set.add("aya");
        set.add("ye");
        set.add("woo");
        set.add("ma");
        String[] str = new String[] {"aya", "ye", "woo", "ma"};
        
        for(String s : babbling) {
            String start = null;
            while(true) {
                boolean c = true;
                for(int i=0; i<str.length; i++) {
                    if(str[i].equals(start)) continue;
                    if(s.startsWith(str[i])) {
                        c = false;
                        s = s.replaceFirst(str[i], "");
                        start = str[i];
                    }
                }
                if(c) break;
            }
            if(s.equals("")) answer++;
        }
        
        return answer;
    }
}