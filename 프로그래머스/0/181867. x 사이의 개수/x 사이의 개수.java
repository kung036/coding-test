import java.util.*;

class Solution {
    public int[] solution(String myString) {
        return Arrays.stream(myString.split("x", myString.length()))
                    .mapToInt(s -> s.length())
                    .toArray();
    }
}