package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class No2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] water = Arrays.stream(br.readLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s))
                .sorted()
                .toArray();

        int left = 0;
        int mid = 0;
        int right = N-1;

        for(int i=0; i<N; i++) {
            if(water[i] > 0) {
                mid = i;
                break;
            }
        }

        while(true) {
            if(water[left] + water[right] > 0) right--;
            else left++;

            if(water[left]+water[right]+water[mid] == 0) break;
            else if(left >= right) {
                if(water[left] >= 0) left--;
                else right--;
                break;
            }

            int before = mid;
            if(water[left]+water[right]+water[mid] > 0) mid--;
            else mid++;

            if(left >= mid || mid >= right) {
                mid = before;
                break;
            }
        }

        System.out.println(water[left] + " " + water[mid] + " " + water[right]);
    }
}