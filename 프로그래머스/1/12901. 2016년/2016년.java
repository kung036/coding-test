import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String[] result = new String[]{"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] days = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = Arrays.stream(Arrays.copyOfRange(days, 0, a)).sum() + b + 4;
        
        return result[day%7];
    }
}