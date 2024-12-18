import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        // "aya", "ye", "woo", "ma" = 10
        int answer = 0;
        String[] possible = new String[] {
            "aya", "ye", "woo", "ma"
        };
        
        for(int i=0; i<babbling.length; i++) {
            String str = babbling[i];
            boolean[] check = new boolean[4];
            
            while(true) {
                boolean unchange = true;
                for(int j=0; j<4; j++) {
                    if(check[j]) continue;
                    if(str.startsWith(possible[j])) {
                        str = str.substring(possible[j].length());
                        check[j] = true;
                        unchange = false;
                    }
                }
                
                if(unchange) break;
            }
            
            if(str.isEmpty()) answer++;
        }
        
        return answer;
    }
}