package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class No3020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 넓이
        int H = sc.nextInt(); // 높이
        int[] arr = new int[H + 1]; // 구간 별 장애물 개수

        int[] bottom = new int[H]; // 석순 길이
        int[] floor = new int[H]; // 종유석 길이

        // 입력
        for (int i = 0; i < N / 2; i++) {
            int tmp = sc.nextInt();
            bottom[tmp]++;

            tmp = sc.nextInt();
            floor[tmp]++;
        }

        // edge 케이스
        arr[H-1] = bottom[H-1];
        arr[2] = floor[H-1];
        int tmp = 3;
        // 누적합으로 구간별 장애물 개수 구하기
        for(int i=H-2; i>=1; i--) {
            bottom[i] = bottom[i+1] + bottom[i];
            floor[i] = floor[i+1] + floor[i];

            arr[i] += bottom[i];
            arr[tmp] += floor[i];
            tmp++;
        }

        // 최소 장애물 개수와 구간 개수 구하기
        int index = 1;
        int min = arr[index];
        int count = 1;
        for (int i = 2; i <= H; i++) {
            if (min > arr[i]) {
                index = i;
                min = arr[i];
                count = 1;
            } else if (min == arr[i]) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}