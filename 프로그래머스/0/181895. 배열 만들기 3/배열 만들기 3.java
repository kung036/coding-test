import java.util.*;

class Solution {
    public int[] solution(int[] arr2, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        for(int[] arr : intervals) {
            for(int i=arr[0]; i<=arr[1]; i++) {
                list.add(arr2[i]);
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}