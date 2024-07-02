import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int max = A;
        int mid = B;
        int min = C;
        
        if(max < mid) {
            max = B;
            mid = A;
        }
        if(max < min) {
            int tmp = max;
            max = min;
            min = tmp;
        }
        if(mid < min) {
            int tmp = mid;
            mid = min;
            min = mid;
        }
        System.out.println(mid);
    }
}