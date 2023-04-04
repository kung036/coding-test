package backjoon;

import java.util.*;

public class No20207 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 일정 개수
        int answer = 0; // 코팅지 넓이
        int[] calendar = new int[366]; // 일정 개수
        int start, end;

        // 일정 등록하기
        for(int i=0; i<N; i++) {
            start = sc.nextInt();
            end = sc.nextInt();

            for(; start <= end; start++) {
                calendar[start]++;
            }
        }

        // 직사각형 넓이 구하기
        int height = 0;
        int width = 0;
        int cur;
        for(int i=1; i<calendar.length; i++) {
            cur = calendar[i];
            if(cur>0) {
                if(cur > height) height = cur;
                width++;
            }
            if((cur==0 && height != 0) || i == calendar.length-1) {
                answer += height * width;
                height = 0;
                width = 0;
            }
        }

        System.out.println(answer);
    }
}
