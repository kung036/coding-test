// 5번 시도 - 25분
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 2 ~ N
        for(int i=2; i<=N; i++) {
            list.add(i);
        }

        int count = 0; // 지우는 개수
        int result = list.get(0); // 마지막으로 지운 수
        int max; // 마지막값
        while(count < K) { // 지우기
            int P = list.get(0);
            max = list.get(list.size()-1);

            int i=1;
            while(P * i <= max) {
                int tmp = P * i++;
                if(list.remove((Integer) tmp)) {
                    count++;
                    result = tmp;
                }
                if(count >= K) break;
            }
        }

        System.out.println(result);
    }
}