import java.util.*;

public class Main {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int count = 0;
        int cur = start;
        
        while(true) {
            // 이전 숫자 : ab => a + b = cd
            // 다음 숫자 : bd
            int a = cur/10;
            int b = cur%10;
            int d = (a+b)%10;
            cur = b*10 + d;
            
            // 종료
            count++;
            if(start == cur) break;
        }
        
        System.out.println(count);
        
    }
}