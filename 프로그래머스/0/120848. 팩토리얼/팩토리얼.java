class Solution {
    public int solution(int n) {
        int answer = 1;
        int i = 1;
        for(; answer<=n; i++) {
            answer *= i;
        }
        
        return i-2;
    }
}