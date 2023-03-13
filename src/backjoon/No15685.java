package backjoon;

import java.io.*;
import java.util.*;

// 드래곤 커브
public class No15685 {
    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(br.readLine()); // 드래곤 커브의 개수
        List<List<Integer>> xys = new ArrayList<>(); // 각 드래곤 커브의 시작 좌표와 xy 리스트
        int ractagle = 0; // 정사각형의 개수

        for(int i=0; i<count; i++) { // 드래곤 커브의 개수만큼 반복
            String[] dragon = br.readLine().split(" ");
            int start_x = Integer.valueOf(dragon[0]); // 시작위치의 x좌표
            int start_y = Integer.valueOf(dragon[1]); // 시작위치의 y좌표
            int dir = Integer.valueOf(dragon[2]); // 시작 방향
            int gen = Integer.valueOf(dragon[3]); // 세대수

            // 현재 드래곤 커브의 xy 경로
            List<Integer> xy = new ArrayList<>();

            for(int j=0; j<gen; j++) { // 세대 수만큼 반복

            }

            xys.add(xy);
        }

        // 사각형 여부 확인하기

        System.out.println(ractagle);
    }

    // 매개변수 xy 좌표의 반시계방향 90도 회전 좌표 반환
    public int[] rotatedLeft90(int x, int y) {
        int[] xy = new int[]{};



        return xy;
    }
}