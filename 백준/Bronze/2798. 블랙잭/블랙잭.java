// 4번 시도 : 32분
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // DFS
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        
        // 입력
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = input[0]; // 횟수
        int max = input[1]; // 최대합
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 입력값
        int size = input.length;
        
        int sum = 0;
        int result = 0;
        
        for(int i=0; i<size-2; i++) {
            sum += input[i];
            for(int j=i+1; j<size-1; j++) {
                sum += input[j];
                for(int k=j+1; k<size; k++) {
                    sum += input[k];
                    if(result < sum && sum <= max) result = sum;
                    sum -= input[k];
                }
                sum -= input[j];
            }
            sum -= input[i];
        }
        
        
        System.out.println(result);
    }
}