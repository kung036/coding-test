// 5번 시도 - 31분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if(Math.max(n, m) != n) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        System.out.println(gcd(n, m));
        System.out.println(lcm(n, m));
    }
    
    // 최대공약수
    public static int gcd(int n, int m) {
        int remain = n % m;
        
        while(m != 0) {
            remain = n % m;
            n = m;
            m = remain;
        }
        
        return n;
    }
    
    // 최소공배수
    public static int lcm(int n, int m) {
        return (n * m) / gcd(n, m);
    }
}