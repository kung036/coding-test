import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int[] index_list) {
        return IntStream.range(0, index_list.length)
                    .mapToObj(i -> my_string.charAt(index_list[i]) + "")
                    .collect(Collectors.joining());
    }
}