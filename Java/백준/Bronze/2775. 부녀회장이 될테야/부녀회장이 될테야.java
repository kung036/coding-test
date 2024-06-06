// 3번 시도 - 32분
import java.util.*;

public class Main {
    static int[][] apt;
    // apt[k][n] = apt[k][n-1] + apt[k-1][n];
    // 0층인 경우 -> apt값은 n호 = n명

    public static void main(String[] args) {
        // a0b호 : (a-1)층의 1~b까지의 사람들의 합
        // 0층 i호의 사람수 = i명
        // 0층 1호부터 시작
        // k층 n호
        // T = Test cast 수
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++) {
            int k = sc.nextInt(); // 층
            int n = sc.nextInt(); // 호
            apt = new int[k+1][n+1]; // k층 n호
            int num = dynamic(k, n);
            System.out.println(apt[k][n]);
        }
    }

    public static int dynamic(int k, int n) {
        // 값이 있으면 그대로 반환
        if(apt[k][n] != 0) return apt[k][n];

        if(n == 1) apt[k][n] = 1; // 1호인 경우
        else if(k == 0) apt[k][n] = n; // 0층인 경우
        else apt[k][n] = dynamic(k, n-1) + dynamic(k-1, n);

        return  apt[k][n];
    }
}