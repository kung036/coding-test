// 3번 시도 - 20분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String[] branch = br.readLine().split(" ");
            int count = Integer.parseInt(branch[0]);
            branch = Arrays.copyOfRange(branch, 1, branch.length);
            int[] arr = Arrays.stream(branch)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            long sum = 0;

            for(int j=0; j<count-1; j++) {
                for(int k = j+1; k < count; k++) {
                    sum += gcd(Math.max(arr[j], arr[k]), Math.min(arr[j], arr[k]));
                }
            }
            System.out.println(sum);
        }

    }

    // 최대공약수
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
