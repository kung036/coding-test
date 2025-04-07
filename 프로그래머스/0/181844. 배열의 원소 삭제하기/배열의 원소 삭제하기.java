import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        // 삭제 목록을 Set으로 변환 (빠른 검색을 위해)
        Set<Integer> deleteSet = Arrays.stream(delete_list)
                                      .boxed()
                                      .collect(Collectors.toSet());
        
        // 삭제 목록에 없는 원소만 필터링
        return Arrays.stream(arr)
                    .filter(num -> !deleteSet.contains(num))
                    .toArray();
    }
}
