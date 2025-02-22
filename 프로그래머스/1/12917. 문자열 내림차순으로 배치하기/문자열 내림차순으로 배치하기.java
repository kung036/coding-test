import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        // 1. 문자열을 문자 배열로 변환
        Character[] charArray = s.chars()
                               .mapToObj(ch -> (char)ch)
                               .toArray(Character[]::new);
        
        // 2. 문자 배열 정렬 (내림차순)
        Arrays.sort(charArray, Collections.reverseOrder());
        
        // 3. 문자 배열을 다시 문자열로 변환
        return Arrays.stream(charArray)
                    .map(String::valueOf)
                    .collect(Collectors.joining());
    }
}
