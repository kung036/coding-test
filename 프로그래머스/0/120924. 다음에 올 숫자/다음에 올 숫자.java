class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int d = common[1] - common[0];
        int n = common.length;
        
        if(common[2] - common[1] == d) {
            // 등차수열
            answer = common[0] + n*d;
        } else { 
            // 등비수열
            answer = common[n-1] * (common[1] / common[0]);
        }
        
        return answer;
    }
}