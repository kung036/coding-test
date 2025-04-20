class Solution {
    public int solution(int[] numbers, int n) {
        int sum = 0;
        for(int i:numbers) {
            if(sum > n) break;
            sum += i;
        }
        return sum;
    }
}