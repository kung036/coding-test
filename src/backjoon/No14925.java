package backjoon;

import java.io.*;
import java.util.*;

// 목장 건설하기
public class No14925 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" ");
        int y = Integer.parseInt(xy[0]); // 세로 M
        int x = Integer.parseInt(xy[1]); // 가로 N

        // 행렬 생성하기
        int[][] arr = new int[y][x];
        for(int i=0; i<y; i++) {
            String[] s = br.readLine().split(" ");
            for(int j=0; j<x; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 농장을 지을 수 있는 들판(0)일 때 dp를 이용해서 확인
        // 2x2를 점점 확장
        int answer = 0; // 정사각형의 한 변 L
        int[][] dp = new int[y+1][x+1];
        for(int i = 1; i <= y; i++){
            for(int j = 1; j <= x; j++){
                if(arr[i-1][j-1] == 0){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        System.out.print(answer);
    }
}