package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No21758 {
    public static int[] honeys; // 꿀의 양
    public static int max = 0; // 획득 가능한 최대 꿀의 양
    public static int count; // 꿀의 개수
    public static int honeys_sum; // 모든 꿀의 양
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 벌통에 꿀 배치
        count = Integer.parseInt(br.readLine()); // 꿀의 개수
        honeys = Arrays.stream(br.readLine().split(" ")).mapToInt(value ->Integer.parseInt(value))
                .toArray();
        honeys_sum = Arrays.stream(honeys).sum();

        findHoney();
        System.out.println(max);
    }

    // 획득 가능한 최대 꿀의 양
    public static void findHoney() {
        // 오른쪽 끝에 벌통이 있고, 왼쪽 끝에 벌이 있고, 벌통과 첫번째 벌이 있는 사이에 두번째 벌이 놓이는 경우
        int bee_box_index = count - 1; // 벌통 위치
        int bee1_index = 0; // 벌1의 위치
        int bee2_index = 1; // 벌2의 위치
        int bee1_honey = honeys_sum - honeys[bee1_index] - honeys[bee2_index]; // 벌1의 획득한 꿀의 양
        int bee2_honey = honeys_sum - honeys[bee1_index]; // 벌2의 획득한 꿀의 양

        for(; bee2_index<bee_box_index; bee2_index++) {
            bee1_honey = bee1_honey + honeys[bee2_index-1] - honeys[bee2_index];
            bee2_honey -= honeys[bee2_index];
            if(bee1_honey+bee2_honey > max) max = bee1_honey + bee2_honey;
        }

        // 왼쪽 끝에 벌통이 있고, 오른쪽 끝에 벌이 있고, 벌통과 첫번째 벌이 있는 사이에 두번째 벌이 놓이는 경우
        bee_box_index = 0;
        bee1_index = count - 1;
        bee2_index = bee1_index - 1;
        bee1_honey = honeys_sum - honeys[bee1_index] - honeys[bee2_index]; // 벌1의 획득한 꿀의 양
        bee2_honey = honeys_sum - honeys[bee1_index]; // 벌2의 획득한 꿀의 양

        for(; bee2_index > bee_box_index; bee2_index--) {
            bee1_honey = bee1_honey + honeys[bee2_index+1] - honeys[bee2_index];
            bee2_honey -= honeys[bee2_index];
            if(bee1_honey+bee2_honey > max) max = bee1_honey + bee2_honey;
        }

        // 양쪽 끝에 벌이 있고, 벌통이 양쪽 벌들 사이에 놓이는 경우
        bee1_index = 0;
        bee2_index = count - 1;
        bee1_honey = 0;
        bee2_honey = honeys_sum - honeys[count-1];

        for(bee_box_index = 1; bee_box_index<bee2_index; bee_box_index++) {
            bee1_honey += honeys[bee_box_index];
            bee2_honey -= honeys[bee_box_index-1];
            if(bee1_honey+bee2_honey > max) max = bee1_honey + bee2_honey;
        }
    }
}