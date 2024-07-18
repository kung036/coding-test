// 6번 시도 - 20분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // M ~ N 소수 구하기
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        // 아리스토텔레스의 체 이용하기
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        
        // 소수 구하기
        for(int i=2; i*i<=n; i++) {
            if(primes[i]) {
                int prime = i;
                // 소수일 경우, 해당하는 배수를 소수에서 제외
                for(int j=2; j*prime<=n; j++) {
                    primes[j*prime] = false;
                }
            }
        }
        
        // 소수 출력하기
        for(int i=m; i<=n; i++) {
            if(primes[i]) System.out.println(i);
        }
    }
}