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
            int tmp = 1;
            boolean b = sushi[count%N] == c ? false : true;
            for(int i=1; i<k; i++) {
                int index = (count+i)%N;
                if(sushi[index] == c) b = false; // 쿠폰 번호가 있는 경우
                if(sushi[index] != sushi[(count+i-1)%N]) tmp++;
            }

            if(answer < tmp) answer = tmp;
            if(tmp == k && b) {
                answer = k+1;
                break;
            }
            count++;
        }

        System.out.println(answer);
    }
}
