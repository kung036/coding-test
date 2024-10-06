import java.util.*;

class Solution {
    int[] fibArr;
    
    public int solution(int n) {
        fibArr = new int[n+1];
        fibArr[0] = 0;
        fibArr[1] = 1;
        return fib(n);
    }
    
    public int fib(int n) {
        if(n == 0) return fibArr[0];
        if(n == 1) return fibArr[1];
        if(fibArr[n] != 0) return fibArr[n];

        fibArr[n] = (fib(n-2) + fib(n-1))%1234567;
        return fibArr[n];
    }
}