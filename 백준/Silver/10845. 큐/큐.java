// 3번 시도 - 25분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            String[] command = br.readLine().split(" ");
            String c = command[0];
            if(c.equals("push")) {
                queue.add(Integer.parseInt(command[1]));
            } else if(c.equals("pop")) {
                if(queue.isEmpty()) System.out.println(-1);
                else System.out.println(queue.poll());
            } else if(c.equals("size")) {
                System.out.println(queue.size());
            } else if(c.equals("empty")) {
                if(queue.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if(c.equals("front")) {
                if(queue.isEmpty()) System.out.println(-1);
                else System.out.println(queue.peek());
            } else if(c.equals("back")) {
                if(queue.isEmpty()) System.out.println(-1);
                else System.out.println(((LinkedList<Integer>)queue).getLast());
            }
        }
    }
}