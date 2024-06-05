// 4번 시도 : 13분
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 올라가는 미터
        int B = sc.nextInt(); // 미끄러지는 미터
        int V = sc.nextInt(); // 나무 막대의 높이
        long day = (long) Math.ceil((double) (V-A)/(A-B)) + 1;

        System.out.println(day);
    }
}