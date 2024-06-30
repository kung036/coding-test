// 5번 시도
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt(); // E <= 15
        int S = sc.nextInt(); // S <= 28
        int M = sc.nextInt(); // M <= 19
        int year = E;

        for(;; year+=15) {
            if(year%28 == S || (year%28 == 0 && S == 28))
                if(year%19 == M || (year%19 == 0 && M == 19)) break;
        }
        
        System.out.println(year);
    }
}