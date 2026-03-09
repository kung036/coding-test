import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        set.add(Arrays.stream(elements).sum());
        int n = elements.length;
        
        // 시작 인덱스
        for(int i=1; i<n; i++) {
            int sum = 0;
            
            // i-1 길이만큼의 합 구하기
            for(int j=0; j<i; j++) {
                sum += elements[j];
            }
            set.add(sum);
            
            // 시작 인덱스
            for(int j=0; j<n; j++) {
                sum -= elements[j];
                sum += elements[(j+i)%n];
                set.add(sum);
            }
        }

        return set.size();
    }
}