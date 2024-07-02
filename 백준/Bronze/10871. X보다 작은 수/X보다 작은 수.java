// 2번 시도 : 12:23
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt(); // 개수
        int max = sc.nextInt(); // 최대수
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<count; i++) {
            int tmp = sc.nextInt();
            if(tmp < max) {
                if(sb.length() == 0) sb.append(tmp);
                else sb.append(" " + tmp);
            }
        }
        
        System.out.println(sb);
    }
}