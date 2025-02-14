class Solution {
    public long solution(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        // a,b의 부호가 다른데 절대값이 같은 경우
        if(max == Math.abs(min) && max == Math.abs(max) && min != Math.abs(min))
            return 0;
        
        long answer = 0;
        
        // a와 b가 부호가 다를 경우
        if(max == Math.abs(max) && min != Math.abs(min)) {
            if(max < Math.abs(min)) { // 음수의 절대값이 더 큰 경우
                max = -1 * (max+1);
            } else { // 양수의 절대값이 더 큰 경우
                min = -1 * (min-1);
            }
        }
        
        // 둘 사이의 합 구하기
        double avg = (max+min) / 2.0;
        long cnt = max-min+1;
        answer = (long)(avg * cnt);
        
        return answer;
    }
}