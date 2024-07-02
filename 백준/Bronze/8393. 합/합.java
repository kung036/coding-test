// 2번 시도 : 1:01
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lastNum = sc.nextInt();

        int sum = (1 + lastNum) * (lastNum/2);
        if(lastNum%2 == 1) sum += lastNum/2 + 1;
        System.out.println(sum);
    }
}