import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int sum = Arrays.stream(num_list).sum();
        return sum * sum < Arrays.stream(num_list).reduce((x,y)-> x*y).getAsInt() ? 0 : 1;
    }
}