import java.util.*;

class Solution {
    public int solution(int[] array) {
        String s = Arrays.toString(array);
        return s.length() - s.replace("7", "").length();
    }
}