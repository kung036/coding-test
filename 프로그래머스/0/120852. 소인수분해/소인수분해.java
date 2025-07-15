import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        // 소수 구하기
        for(int i=2; i<=n; i++) {
            for(int j=2; j<=i; j++) {
                if(i%j == 0 && i==j) list.add(i);
                else if(i%j == 0) break;
            }
        }
        
        // 소인수분해 구하기
        Set<Integer> set = new HashSet<>();
        while(n > 1) {
            for(int i : list) {
                if(n%i == 0) {
                    set.add(i);
                    n /= i;
                }
            }
        }
        
        return set.stream().sorted((o1, o2) -> Integer.compare(o1, o2)).mapToInt(i -> i).toArray();
    }
}