import java.util.*;

public class Solution {
    public int solution(int n) {
        // n을 string을 변경 후 1자리로 나누고
        // 숫자로 변경해서 더하기
        
        return (int) Arrays.stream(("" + n).split(""))
            .mapToInt(Integer::valueOf)
            .sum();
    }
}