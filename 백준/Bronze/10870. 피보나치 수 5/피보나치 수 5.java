// 4번 시도 : 8분
import java.util.*;

public class Main {
    static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new long[n+1];
        long result = fib(n);
        System.out.println(result);
    }
    
    public static long fib(int n) {
        if(arr[n] != 0) return arr[n];
        
        if(n == 0) arr[n] = 0;
        else if(n == 1 || n == 2) arr[n] = 1;
        else arr[n] = fib(n-1) + fib(n-2);
        
        return arr[n];
    }
}