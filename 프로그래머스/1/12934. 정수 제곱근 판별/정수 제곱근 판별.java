class Solution {
    public long solution(long n) {
    long answer = -1;
    for(long num=1; num*num <= n; num++)
        if(n == num*num) {
            answer = (num+1)*(num+1);
            break;
        }
    
    return answer;
    }
}