import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int n = (int) Arrays.stream(arr).filter(i->i==2).count();
        if(n == 0) return new int[]{-1};
        if(n == 1) return new int[]{2};
        
        int x = 0;
        for(int i : arr) {
            if(i == 2) x++;
            if(x > 0) list.add(i);
            if(x == n) break;
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}