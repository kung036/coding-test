import java.util.*;

class Solution {
    public int solution(int n, int k) {
        // k진수로 바꾸기
        String[] p = Integer.toString(n, k).split("0");
        
        // P를 구한 후 소수인지 확인하기
        int answer = 0;
        for(int i=0; i<p.length; i++) {
            if(p[i].isEmpty()) continue;
            long num = Long.valueOf(p[i]);
            if(prime(num)) answer++;
        }

        return answer;
    }
    
    public boolean prime(long n) {
        if(n == 1) return false;
        if(n == 2) return true;
        if(n%2 == 0) return false;
        
        for(long i=3; i*i<=n; i+=2) {
            if(n%i == 0) return false;
        }
        return true;
    }
}