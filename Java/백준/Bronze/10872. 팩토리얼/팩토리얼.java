// 1번 시도 : 5qns
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long result = 1;
        
        for(int i=1; i<=n; i++) {
            result *= i;
        }
        
        System.out.println(result);
    }
}