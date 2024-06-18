// 5번 시도 - 42분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int size = arr[0];
            int index = arr[1];

            // size가 1일 경우
            if(size == 1) {
                br.readLine();
                System.out.println(1);
                continue;
            }

            // Queue 구성
            int[] content = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
//            System.out.println(Arrays.toString(content));
            Queue<Integer> queue = new LinkedList<>();
            for(int j=0; j<size; j++) {
                queue.offer(content[j]);
            }

            // 길이 계산
            int max;
            int count = 0; // 프린트된 횟수
            while(true) {
                max = queue.stream()
                        .mapToInt(Integer::intValue)
                        .max()
                        .getAsInt();
//                System.out.println(queue.peek() + " : " + max + " " + index);
                if(queue.peek() == max) { // 가장 큰 수인 경우
                    count++;
                    if(index == 0) break;
                    index--;
                    queue.poll();
                } else {
                    if(index == 0) index = queue.size() - 1;
                    else index--;
                    queue.offer(queue.poll());
                }
            }
            System.out.println(count);
        }
    }
}