import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = new int[]{a, b, c, d};
        Arrays.sort(arr);
        
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
            else map.put(arr[i], 1);
        }
        
        int p = 0, q = 0, r = 0;
        for(int i : map.keySet()) {
            if(map.get(i) == 4) p = i;
            else if(map.get(i) == 3) p = i;
            else if(map.get(i) == 2) {
                if(p == 0) p = i;
                else q = i;
            } else if(q == 0) q = i; 
            else r = i;
        }
        
        if(map.size() == 1) answer = 1111 * p;
        else if(map.size() == 4) answer = arr[0];
        else if(map.size() == 3) answer = q * r;
        else if(map.get(p) == 2) answer = (p+q) * Math.abs(p-q);
        else answer = (10*p + q) * (10*p + q);
        
        return answer;
    }
}