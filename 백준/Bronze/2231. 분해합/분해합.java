// 4번 시도 : 30분
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int max = 0; // 생성자
        int len = Integer.toString(input).length();
        
        for(int i = input - len * 9; i<=input; i++) {
            int sum = i;
            int tmp = i;

            while(tmp != 0) {
                sum += tmp%10;
                tmp /= 10;
            }
            
            if(sum == input) {
                max = i;
                break;
            }
        }
        
        System.out.println(max);
    }
}