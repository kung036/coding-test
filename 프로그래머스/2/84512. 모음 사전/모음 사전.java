import java.util.*;

class Solution {
    char[] alpha = new char[] {'A', 'E', 'I', 'O', 'U'};
    char[] find = new char[5];
    int answer;
    String word;
    
    public int solution(String word) {
        this.word = word;
        backtrack(0, 0, find);
        return answer;
    }
    
    public int backtrack(int index, int cnt, char[] find) {
        if(answer != 0) return cnt;
        
        String str = new String(find);
        if(word.equals(str.trim())) {
            answer = cnt;
            return cnt;
        }
        if(index == 5) return cnt;
        
        for(int i=0; i<5; i++) {
            find[index] = alpha[i];
            cnt = backtrack(index+1, cnt+1, find);
            find[index] = ' ';
        }
        
        return cnt;
    }
}