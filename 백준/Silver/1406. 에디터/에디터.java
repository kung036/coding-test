// 4번 시도 : 18분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // 입력되어 있는 문자열
        int N = Integer.parseInt(br.readLine()); // 명령어 개수
        Stack<String> leftStack = new Stack<>(); // 커서 왼쪽 stack
        Stack<String> rightStack = new Stack<>(); // 커서 오른쪽 stack

        // 입력되어 있는 문자열을 왼쪽 stack에 넣음
        for(int i=0; i<str.length(); i++) {
            leftStack.push(String.valueOf(str.charAt(i)));
        }

        // 명령어 실행
        for(int i=0; i<N; i++) {
            String command = br.readLine(); // 명령어
            if(command.equals("L")) { // 커서 왼쪽 이동
                if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
            } else if(command.equals("D")) { // 커서 오른쪽 이동
                if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());
            } else if(command.equals("B")) { // 커서 왼쪽 제거
                if(!leftStack.isEmpty()) leftStack.pop();
            } else { // P $ -> $문자를 커서 왼쪽에 추가
                leftStack.push(command.split("P ")[1]);
            }
        }

        // 명령어 출력
        while(!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb.toString());
    }
}