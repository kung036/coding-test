// 7번 시도 - 18분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++) {
            String[] command = br.readLine().split(" ");
            if(command[0].equals("push")) { // push 명령어인 경우
                stack.push(Integer.parseInt(command[1]));
            } else if(command[0].equals("top")) { // top : 없으면 -1
                if(!stack.isEmpty()) System.out.println(stack.peek());
                else System.out.println(-1);
            } else if(command[0].equals("size")) { // size : 크기
                System.out.println(stack.size());
            } else if(command[0].equals("empty")) { // empty : 비어잇으면 1, 없으면 0
                if(stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if(command[0].equals("pop")) {
                if(!stack.isEmpty()) System.out.println(stack.pop());
                else System.out.println(-1);
            }
        }
    }
}