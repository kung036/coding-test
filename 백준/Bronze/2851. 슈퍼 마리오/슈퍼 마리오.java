// 2번 시도 : 16분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[10];
        for(int i=0; i<10; i++) input[i] = Integer.parseInt(br.readLine());

        int result = 0;
        int sum = 0;
        for(int i=0; i<input.length; i++) {
            sum += input[i];
            if(Math.abs(sum - 100) < Math.abs(result - 100))
                result = sum;
            else if(Math.abs(sum - 100) == Math.abs(result - 100))
                result = sum < result ? result : sum;
        }

        System.out.println(result);
    }
}