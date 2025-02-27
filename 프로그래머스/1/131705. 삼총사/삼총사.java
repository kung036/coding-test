class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int n = number.length;
        
        for(int i=0; i<n-2; i++) {
            int sum = number[i];
            for(int j=i+1; j<n-1; j++) {
                sum += number[j];
                for(int k=j+1; k<n; k++) {
                    if(sum+number[k] == 0) answer++;
                }
                sum -= number[j];
            }
        }
        
        return answer;
    }
}