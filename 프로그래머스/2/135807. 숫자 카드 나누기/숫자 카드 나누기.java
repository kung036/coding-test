import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // 배열 A와 B의 최대공약수 구하기
        int gcdA = getGCD(arrayA);
        int gcdB = getGCD(arrayB);

        // 상대 배열의 모든 요소를 나눌 수 없는지 확인
        boolean isValidA = isGCDValid(gcdA, arrayB);
        boolean isValidB = isGCDValid(gcdB, arrayA);

        // 결과 계산
        if (isValidA && isValidB) {
            return Math.max(gcdA, gcdB); // 둘 다 유효하면 더 큰 값 반환
        } else if (isValidA) {
            return gcdA; // gcdA만 유효
        } else if (isValidB) {
            return gcdB; // gcdB만 유효
        } else {
            return 0; // 둘 다 유효하지 않으면 0 반환
        }
    }

    // 배열의 최대공약수를 구하는 함수
    private int getGCD(int[] array) {
        int gcd = array[0];
        for (int i = 1; i < array.length; i++) {
            gcd = GCD(gcd, array[i]);
        }
        return gcd;
    }

    // 유클리드 호제법으로 최대공약수를 구하는 함수
    private int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    // 최대공약수가 상대 배열의 모든 요소를 나눌 수 없는지 확인하는 함수
    private boolean isGCDValid(int gcd, int[] array) {
        for (int num : array) {
            if (num % gcd == 0) {
                return false; // 나눌 수 있으면 유효하지 않음
            }
        }
        return true;
    }
}
