class Solution {
    public int solution(int n) {
        int answer = 0;
        int idx = 0;
        
        for(int j=2; j<=n; j++) {
            for(int i=2; i*i<=j; i++) {
                if(j%i == 0) {
                    idx++;
                    break;
                }
            }
            if(idx == 0) answer++;
            idx = 0;
        }
        
        return answer;
    }
}