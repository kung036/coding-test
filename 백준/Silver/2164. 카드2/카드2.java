// 3번 시도 - 6분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 위 1 <-> N
        // 규칙1. 제일 위에 있는 카드(1) 버리기
        // 규칙2. 제일 위에 있는 카드를 마지막에 보낸다.
        // 규칙3. 규칙 1, 2를 반복해서 카드가 1개가 남을 때까지 반복한다.
        // <- 1 2 3 4 -> Queue에 1부터 N까지 넣기 
        // 길이가 1인지 확인
        // <-   2 3 4 -> Queue.poll
        // <-   3 4 2 -> Queue.poll한 값을 offer함
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            queue.offer(i);
        }
        
        while(true) {
            if(queue.size() == 1) break;
            
            queue.poll();
            int next = queue.poll();
            queue.offer(next);
        }
        
        System.out.println(queue.peek());
    }
}