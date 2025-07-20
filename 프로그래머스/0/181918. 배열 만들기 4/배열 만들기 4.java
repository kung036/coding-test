import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // 1. stk.isEmpty() : stk[0] = arr[i], i++
        // 2. stk[마지막 원소] < arr[i] : stk[마지막 원소+1] = arr[i], i++
        // 3. stk[마지막 원소] >= arr[i] : stk[마지막 원소] 제거
        List<Integer> stk = new ArrayList<>();
        int i = 0;
        while(i < arr.length) {
            if(stk.isEmpty()) stk.add(arr[i++]);
            else if(stk.get(stk.size()-1) < arr[i]) stk.add(arr[i++]);
            else stk.remove(stk.size()-1);
        }
        
        return stk.stream().mapToInt(d->d).toArray();
    }
}