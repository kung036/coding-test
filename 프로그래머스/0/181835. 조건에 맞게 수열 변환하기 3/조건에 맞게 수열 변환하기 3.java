import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        return k%2 == 1 ?
                Arrays.stream(arr).map(a -> a*k).toArray()
                : Arrays.stream(arr).map(a -> a+k).toArray();
    }
}