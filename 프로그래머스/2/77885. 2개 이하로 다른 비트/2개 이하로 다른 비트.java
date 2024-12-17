class Solution {
    public long[] solution(long[] numbers) {
        int n = numbers.length;
        long[] answer = new long[n];
        
        for (int i = 0; i < n; i++) {
            long num = numbers[i];
            
            // 짝수인 경우 +1만 하면 조건 만족
            if (num % 2 == 0) {
                answer[i] = num + 1;
            } else {
                // 홀수인 경우 가장 낮은 0 비트를 1로, 그 다음 1 비트를 0으로
                long lowestZero = ~num & (num + 1); // 가장 낮은 0 비트 찾기
                long bitToChange = (lowestZero >> 1); // 바로 다음 1 비트를 0으로 변경
                answer[i] = num + lowestZero - bitToChange;
            }
        }
        
        return answer;
    }
}