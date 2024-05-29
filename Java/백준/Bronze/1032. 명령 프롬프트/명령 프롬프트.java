// 3번 시도 : 14:57
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt(); // 단어 개수

        StringBuilder sb = new StringBuilder();
        sb.append(sc.next());
        int wordSize = sb.length();

        for(int i=1; i<count; i++) {
            String next = sc.next();

            for(int j=0; j<wordSize; j++) {
                if(sb.charAt(j) == '?') continue;
                if(sb.charAt(j) != next.charAt(j))
                    sb.setCharAt(j, '?');
            }
        }

        System.out.println(sb);
    }
}