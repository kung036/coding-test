// 4번 시도 - 10분
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            int cur = Integer.parseInt(br.readLine());
            if(cur == 0) stack.pop();
            else stack.push(cur);
        }

        System.out.println(stack.stream().mapToInt(Integer::intValue).sum());
    }
}