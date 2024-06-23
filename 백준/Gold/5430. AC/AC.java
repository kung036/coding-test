import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for(int i = 0; i < T; i++) {
            String[] ps = br.readLine().split(""); // 실행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열의 크기

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
            for (String p : ps) {
                if (p.equals("R")) {
                    front = !front; // 방향 전환
                } else if (p.equals("D")) {
                    if (arr.isEmpty()) {
                        System.out.println("error");
                        finish = false;
                        break;
                    } else {
                        if (front) {
                            arr.pollFirst();
                        } else {
                            arr.pollLast();
                        }
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
