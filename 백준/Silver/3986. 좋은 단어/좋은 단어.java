// 5번 시도 - 19분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 0;
        
        for(int i=0; i<n; i++) {
            String[] word = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            for(int j=0; j<word.length; j++) {
                String cur = word[j];
                if(!stack.isEmpty() && stack.peek().equals(cur)) stack.pop();
                else stack.push(cur);
            }
            if(stack.isEmpty()) num++;
        }
        
        System.out.println(num);
    }
}