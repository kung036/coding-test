package backjoon;

import java.util.*;
import java.util.stream.Collectors;

public class No15961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 접시의 수
        int d = sc.nextInt(); // 초밥의 가짓수
        int k = sc.nextInt(); // 연속해서 먹는 접시의 수
        int c = sc.nextInt(); // 쿠폰 번호

        int answer = 0; // 손님이 먹을 수 있는 초밥의 최대 가짓수

        List<Integer> couponIndex = new ArrayList<>();
        int[] sushi = new int[N];
        for(int i=0; i<N; i++) {
            sushi[i] = sc.nextInt();
            if(sushi[i] == c) couponIndex.add(i);
        }
        couponIndex = couponIndex.stream()
                .sorted()
                .collect(Collectors.toList());

        int count = 0;
        while(count < N) {
            while (true) {

            }


            if(answer == k+1) break;
            count++;
        }

        System.out.println(answer);
    }
}
