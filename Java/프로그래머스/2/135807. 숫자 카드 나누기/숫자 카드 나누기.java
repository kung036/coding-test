import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // 최대공약수 구하기
        int gcdA = gcds(arrayA);
        int gcdB = gcds(arrayB);
        
        // gcd로 다른 배열이 나눠지는지 확인하기
        boolean validA = isValid(arrayB, gcdA);
        boolean validB = isValid(arrayA, gcdB);
        
        // 정답 구하기
        int answer = 0;
        if(validA && validB) answer = Math.max(gcdA, gcdB);
        else if(validA) answer = gcdA;
        else if(validB) answer = gcdB;
        
        return answer;
    }
    
    public int gcd(int num1, int num2) {
          if (num1 % num2 == 0) return num2;
          return gcd(num2, num1%num2);
    }
    
    public int gcds(int[] arr) {
        int gcd = arr[0];
        for(int i=1; i<arr.length; i++) {
            gcd = gcd(arr[i], gcd);
        }
        return gcd;
    }
    
    public boolean isValid(int[] arr, int gcd) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] % gcd == 0) return false;
        }
        
        return true;
    }
}