package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No22945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // 사람 수
        int[] delvelope = Arrays.stream(br.readLine().split(" "))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray(); // 개발자의 능력치

        int left = 0, right = num-1;
        int ans = 0; // 팀빌딩된 팀의 최댓값
        while(left<=right) {
            int min = Math.min(delvelope[left],delvelope[right]);
            ans = Math.max((right-left-1) * min, ans);
            if(delvelope[left] < delvelope[right]) left++;
            else right--;
        }

        System.out.println(ans);
    }
}
