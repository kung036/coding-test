import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 진입 지점을 기준으로 정렬
        Arrays.sort(routes, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        
        int answer = 1;
        int n = routes.length;
        int start = routes[0][0];
        int end = routes[0][1];
        for(int i=1; i<n; i++) {
            int nStart = routes[i][0];
            int nEnd = routes[i][1];

            if(start<=nStart && nStart<=end) {
                start = Math.max(start, nStart);
                end = Math.min(end, nEnd);
            } else {
                answer++;
                start = nStart;
                end = nEnd;
            }
        }

        return answer;
    }
}