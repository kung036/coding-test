import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        // 그리디 알고리즘 이용
        
        // d 오름차순 정렬
        Arrays.sort(d);
        
        // 부서를 하나씩 선택하면서 budget이 초과할 때까지 반봅
        int answer = 0;
        for(int s : d) {
            if(budget-s < 0) break;
            budget -= s;
            answer++;
        }
        
        return answer;
    }
}