import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        Arrays.sort(indices);

        for(int i=0; i<indices.length; i++) {
            sb.deleteCharAt(indices[i]-i);
        }
        
        return sb.toString();
    }
}