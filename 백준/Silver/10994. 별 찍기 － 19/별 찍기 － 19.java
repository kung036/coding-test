// 4번 시도 - 27분
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();

        // 네모길이 = line * 4 + 1
        // 큰 네모부터 채우기
        int n = (line-1) * 4 + 1;
        int[][] star = new int[n][n];
        int startIndex = 0; // 시작지점

        // 별 채우기
        for(int i=0; i<line; i++) {
            for(int j=startIndex; j<startIndex+n; j++) {
                star[startIndex][j]++; // 윗줄
                star[star.length-1-startIndex][j]++; // 아랫줄
                star[j][startIndex]++; // 왼쪽줄
                star[j][star.length-1-startIndex]++; // 오른쪽줄
            }
            n -= 4; // 큰 네모의 길이
            startIndex += 2; // 길이의 시작지점
        }

        // 별 그리기
        for(int i=0; i<star.length; i++) {
            for(int j=0; j<star[i].length; j++) {
                if(star[i][j] != 0) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println("");
        }
    }
}