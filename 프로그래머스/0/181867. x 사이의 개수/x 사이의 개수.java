import java.util.*;

class Solution {
    public int[] solution(String myString) {
        if(myString.charAt(myString.length()-1) == 'x')
            myString += "0";
        int[] answer = Arrays.stream(myString.split("x"))
                    .mapToInt(s -> s.length())
                    .toArray();
        if(myString.charAt(myString.length()-1) == '0')
            answer[answer.length-1] = 0;
        
        return answer;
    }
}