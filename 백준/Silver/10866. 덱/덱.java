// 5번 시도 - 14분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            String[] comment = br.readLine().split(" ");
            String c = comment[0];
            
            if(c.equals("push_front")) {
                deque.offerFirst(Integer.parseInt(comment[1]));
            } else if(c.equals("push_back")) {
                deque.offerLast(Integer.parseInt(comment[1]));
            } else if(c.equals("pop_front")) {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollFirst());
            } else if(c.equals("pop_back")) {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollLast());
            } else if(c.equals("size")) {
                System.out.println(deque.size());
            } else if(c.equals("empty")) {
                if(deque.isEmpty()) System.out.println(1);
                else System.out.println(0);                
            } else if(c.equals("front")) {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekFirst());
            } else if(c.equals("back")) {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekLast());
            }
        }
    }
}