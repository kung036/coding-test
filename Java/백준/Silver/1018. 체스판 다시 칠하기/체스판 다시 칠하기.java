// 5번 시도 : 35분
import java.util.*;

public class Main {
    private static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 세로
        int M = sc.nextInt(); // 가로

        arr = new char[N][M]; // 체스판
        for(int i=0; i<N; i++) {
            arr[i] = sc.next().toCharArray();
        }

        int min = 8*8; // 최소 색칠하는 개수
        for(int i=0; i<=N-8; i++) {
            for(int j=0; j<=M-8; j++) {
                int curCount = count(i, j);
                if(min > curCount) min = curCount;
            }
        }

        System.out.println(min);
    }

    public static int count(int startY, int startX) {
        int sum = 0;
        int index = 0;

        // 시작 인덱스 (startY, startX)
        for(int i=startY; i<startY+8; i++) {
            for(int j=startX; j<startX+8; j++) {
                // W로 시작하는 경우
                if(index%2 == 0 && 'W' == arr[i][j]) sum++;
                if(index%2 == 1 && 'B' == arr[i][j]) sum++;
                index++;
            }
            index++;
        }
        int sum2 = 64 - sum;
        return sum < sum2 ? sum : sum2;
    }
}