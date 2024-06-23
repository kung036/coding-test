// 6번 시도 - 67분
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 함수 R : 배열에 있는 수의 순서 뒤집기
        // 함수 D : 배열의 첫번째 수 버리기

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for(int i=0; i<T; i++) {
            String[] ps = br.readLine().split(""); // 실행할 함수
            int n = Integer.parseInt(br.readLine()); // 함수 개수

            // 배열
            String input = br.readLine();
            Deque<Integer> arr = new LinkedList<>();
            if (n > 0) {
                String[] tmp = input.substring(1, input.length() - 1).split(",");
                arr = Arrays.stream(tmp)
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayDeque::new));
            }

            // 함수 실행
            boolean finish = true;
            boolean front = true;
            for(int j=0; j<ps.length; j++) {
                String p = ps[j]; // 현재 실행하는 함수
                if(p.equals("R")) front = !front;
                else if(p.equals("D")) {
                    if(arr.isEmpty()) {
                        System.out.println("error");
                        finish = false;
                        break;
                    } else if(front) {
                        arr.pollFirst();
                    } else {
                        arr.pollLast();
                    }
                }
            }
            if (finish) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (front) {
                    while (!arr.isEmpty()) {
                        sb.append(arr.pollFirst());
                        if (!arr.isEmpty()) sb.append(",");
                    }
                } else {
                    while (!arr.isEmpty()) {
                        sb.append(arr.pollLast());
                        if (!arr.isEmpty()) sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }
}