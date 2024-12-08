import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        set.add(Arrays.stream(elements).sum());
        int n = elements.length;
        
        for(int i=1; i<n; i++) { // 연속 부분 수열의 길이
            int sum = 0;
            // i-1 길이만큼의 합 구하기
            for(int j=0; j<i; j++) {
                sum += elements[j];
            }
            set.add(sum);
            
            for(int j=0; j<n; j++) { // 시작 인덱스
                sum -= elements[j];
                sum += elements[(j+i)%n];
                set.add(sum);
            }
        }

        return set.size();
    }
}