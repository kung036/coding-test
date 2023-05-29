package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class No2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] water = Arrays.stream(br.readLine().split(" "))
                .mapToLong(s -> Long.parseLong(s))
                .sorted()
                .toArray();

        Long[] ans = { water[0], water[1], water[2] };
        Long sum = Math.abs(water[0] + water[1] + water[2]);

        for(int i=0; i<N-2; i++) {
            Long fixed = water[i];
            int left = i+1;
            int right = N-1;

            while(left<right) {
                Long tmp_sum = fixed + water[left] + water[right];
                if(Math.abs(tmp_sum) < sum) {
                    ans[0] = fixed;
                    ans[1] = water[left];
                    ans[2] = water[right];
                    sum = Math.abs(tmp_sum);
                }

                if(0 < tmp_sum) right--;
                else if(tmp_sum < 0) left++;
                else {
                    System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
                    return;
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}