import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String letter) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<String, String> map = new HashMap<>();
        char c = 'a';
        for(int i=0; i<morse.length; i++) {
            map.put(morse[i], (char)(c+i)+"");
        }
        return Arrays.stream(letter.split(" "))
                    .map(s -> map.get(s))
                    .collect(Collectors.joining());
    }
}