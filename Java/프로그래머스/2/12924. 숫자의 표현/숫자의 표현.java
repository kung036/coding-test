class Solution {
    public int solution(int n) {
        int answer = 1;
        int sum;

        for(int i=1; i<n; i++) {
            sum = 0;
            for(int j=i; ; j++) {
                sum += j;
                if(sum == n) {
                    answer++;
                    break;
                }
                else if(sum > n) break;
            }
        }

        return answer;
    }
}