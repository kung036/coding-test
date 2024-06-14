// 4번 시도 : 21분
import java.util.*;

public class Main {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();
        hanoi(1, 3, 2, level);
        System.out.println(count);
        System.out.println(sb.toString());        
    }

    public static void hanoi(int cur, int mov, int aux, int level) {
        if(level == 1) {
            sb.append(cur + " " + mov + "\n");
            count++;
            return;
        }
        hanoi(cur, aux, mov, level-1);
        count++;
        sb.append(cur + " " + mov + "\n");
        hanoi(aux, mov, cur, level-1);
    }
}