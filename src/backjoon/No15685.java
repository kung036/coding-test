package backjoon;

import java.io.*;
import java.util.*;

// 드래곤 커브
public class No15685 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(br.readLine()); // 드래곤 커브의 개수
        int answer = 0; // 정사각형의 개수
        boolean[][] xy = new boolean[101][101]; // xy 좌표계 (초기값 : false)

        // xy 좌표 (오른쪽, 위쪽, 왼쪽, 아래쪽)
        int[] x = new int[]{1, 0, -1, 0};
        int[] y = new int[]{0, -1, 0, 1};

        for(int i=0; i<count; i++) { // 드래곤 커브의 개수만큼 반복
            String[] dragon = br.readLine().split(" ");
            int current_x = Integer.valueOf(dragon[0]); // 시작위치의 x좌표
            int current_y = Integer.valueOf(dragon[1]); // 시작위치의 y좌표
            int gen = Integer.valueOf(dragon[3]); // 세대수

            // 드래곤 커브의 방향
            List<Integer> dir = new ArrayList<>();

            // 드래곤 커브의 이동 좌표
            dir.add(Integer.valueOf(dragon[2])); // 시작 방향 추가
            xy[current_x][current_y] = true; // 시작 좌표
            current_x = current_x + x[dir.get(0)];
            current_y = current_y + y[dir.get(0)];
            xy[current_x][current_y] = true; // 이동 좌표

            if(gen != 0) rotate(dir, xy, current_x, current_y, gen); // 재귀호출
        }

        // 사각형 여부 확인하기
        for(int i=0; i<xy.length-1; i++) {
            for(int j=0; j<xy[i].length-1; j++) {
                if(xy[i][j] && xy[i+1][j] && xy[i][j+1] && xy[i+1][j+1]) answer++;
            }
        }

        System.out.println(answer);
    }

    // 현재 list의 역순으로 반시계방향 90도 회전한 방향을 list에 추가하기 && 이동 좌표값 true로 변경
    // 0 : 오른쪽, 1 : 위쪽, 2 : 왼족, 3 : 아래쪽
    public static void rotate(List<Integer> dir, boolean[][] xy, int current_x, int current_y, int gen) {
        // xy 좌표 (오른쪽, 위쪽, 왼쪽, 아래쪽)
        int[] x = new int[]{1, 0, -1, 0};
        int[] y = new int[]{0, -1, 0, 1};

        for(int i = dir.size()-1; i>=0; i--) {
            int d = (dir.get(i)+1)%4; // 현재 이동 방향

            // 현재 list의 역순으로 반시계방향 90도 회전한 방향을 list에 추가하기
            dir.add(d);

            // 이동 좌표값 true로 변경
            current_x = current_x + x[d];
            current_y = current_y + y[d];
            xy[current_x][current_y] = true;
        }

        if(--gen > 0) rotate(dir, xy, current_x, current_y, gen);
    }
}