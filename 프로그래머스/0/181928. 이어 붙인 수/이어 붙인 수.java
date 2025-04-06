import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] num_list) {
        String odd = Arrays.stream(num_list)
                        .filter(n -> n%2 == 1)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(""));
        String even = Arrays.stream(num_list)
                        .filter(n -> n%2 == 0)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(""));
        
        return Integer.valueOf(odd) + Integer.valueOf(even);
    }
}