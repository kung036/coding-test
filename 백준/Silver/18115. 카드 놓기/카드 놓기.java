// 10번 시도 - 33분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        // deque -> result
        // 기술 1 : 위에 1장 내려놓기
        // 기술 2 : 위에서 2번째장 내려놓기
        // 기술 3 : 제일 아래있는 카드 내려놓기

        // 최종 카드 배치
        Deque<Integer> deque = new LinkedList<>();

        // 명령어를 역술으로 실행해서 초기 카드 상태 확인
        int j = 1;
        for(int i=n; i>0; i--) {
            String skill = arr[i-1];
            if(skill.equals("1")) {
                deque.offerFirst(j++);
            } else if(skill.equals("2")) {
                int tmp = deque.pollFirst();
                deque.offerFirst(j++);
                deque.offerFirst(tmp);
            } else if(skill.equals("3")) {
                deque.offerLast(j++);
            }
        }

        // 출력 : 초기 카드 상태를 위에서부터 순차적으로 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(deque.pollFirst()).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}