class Solution {
    int answer = 0;
    int n;
    int target;
    int[] numbers;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        n = numbers.length;
        dfs(0, 0);
        return answer;
    }
    
    public void dfs(int idx, int sum) {
        if(idx == n) {
            if(target == sum) answer++;
            return;
        }
        
        dfs(idx+1, sum-numbers[idx]);
        dfs(idx+1, sum+numbers[idx]);
    }
}