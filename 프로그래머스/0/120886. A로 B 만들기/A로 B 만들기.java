import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] cb = before.toCharArray();
        char[] ca = after.toCharArray();
        Arrays.sort(cb);
        Arrays.sort(ca);

        StringBuilder b = new StringBuilder(new String(cb));
        StringBuilder a = new StringBuilder(new String(ca));
        return b.toString().equals(a.toString()) ? 1 : 0;
    }
}