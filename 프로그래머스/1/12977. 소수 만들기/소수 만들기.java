import java.util.*;

class Solution {
    Map<Integer, Boolean> map = new HashMap<>();
    
    public int solution(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int answer = 0;

        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if(sosu(sum)) answer++;
                }
            }
        }        

        return answer;
    }
    
    public boolean sosu(int n) {
        if (map.containsKey(n)) return map.get(n);
        if (n < 2) {
            map.put(n, false);
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                map.put(n, false);
                return false;
            }
        }
        map.put(n, true);
        return true;
    }
}