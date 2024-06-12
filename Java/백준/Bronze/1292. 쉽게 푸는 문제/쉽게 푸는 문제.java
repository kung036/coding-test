// 3번 시도 - 13분
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int finish = sc.nextInt();
        int[] arr = new int[1001];
        int sum = 0;
        int count = 1; // 현재 번호
        int count_index = 1; // 현재 번호를 반복한 횟수
        
        for(int i=1; i<arr.length; i++) {            
            if(start <= i) sum += count;
            if(finish == i) break;
            
            if(count_index == count) {
                count++;
                count_index = 1;
            } else count_index++;
        }
        
        System.out.println(sum);
    }
}