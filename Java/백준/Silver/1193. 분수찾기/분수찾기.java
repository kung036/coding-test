// 3번 시도 : 28분
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        // 1번 : 1/1 (1)
        // 2번 : 1/2 -> 2/1 (2, 3)
        // 3번 : 1/3 -> 2/2 -> 3/1 (4, 5, 6)
        // 4번 : 1/4 -> 2/3 -> 3/2 -> 4/1 (7, 8, 9, 10)
        // 5번 : 1/5 -> 2/3 -> 3/3 -> 4/2 -> 5/1 (11, 12, 13, 14, 15)
        // n번째 : tmp = (num - sum), sum = 1 ~ (n-1)의 합
        // n = "sum<=num<=for합" i값
        // 결과 :  tmp / (n-tmp+1) -> 짝수일 때
        int sum=1;
        int n = 1;
        for(int i=2; i<=num; i++) {
            if(sum <= num && num <= sum+i) {
                n = i;
                break;
            }
            sum += i;
        }
        
        int tmp = num - sum;
        int bottom = n - tmp + 1;
        if(num == 1)System.out.println("1/1");
        else if(n%2 == 0) System.out.println(tmp + "/" + bottom);
        else System.out.println(bottom + "/" + tmp);
    }
}