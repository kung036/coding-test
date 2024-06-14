// 7번 시도 - 14분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            String[] ps = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            boolean vps = true;
            
            for(int j=0; j<ps.length; j++) {
                String cur = ps[j];
                if(cur.equals(")")) {
                    if(stack.isEmpty() || stack.peek().equals(")")) { 
                        vps = false;
                        break;
                    } else stack.pop();
                } else stack.push(cur);
            }
            
            // 출력
            if(vps && stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}