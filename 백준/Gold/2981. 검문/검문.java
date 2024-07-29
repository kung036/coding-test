// 모둘로 연산과 최대공약수를 이용한 문제
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr); // 오름차순 정렬
        
        // 두 수가 모듈러 연산이 적용될 때 : a = b (mod M)
        // a - b는 M의 배수 -> 이 차이값의 최대공약수 구하기
        int gcdValue = arr[1] - arr[0];
        for (int i = 2; i < N; i++) {
            gcdValue = gcd(gcdValue, arr[i] - arr[i - 1]);
        }
        
        // 최대공약수의 약수들이 모듈러 연산의 값
        Set<Integer> resultSet = new TreeSet<>(); // 자동 오름차순 정렬
        for (int i = 1; i <= Math.sqrt(gcdValue); i++) { // 효율적인 약수 구하기(sqrt)
            if (gcdValue % i == 0) {
                resultSet.add(i);
                resultSet.add(gcdValue / i);
            }
        }
        
        for (int res : resultSet) {
            if (res != 1) {
                System.out.print(res + " ");
            }
        }
    }
    
    // 최대공약수
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
