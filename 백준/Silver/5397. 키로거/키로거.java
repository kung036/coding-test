import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Deque<Character> leftStack = new ArrayDeque<>();
            Deque<Character> rightStack = new ArrayDeque<>();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '<') {
                    if (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                } else if (c == '>') {
                    if (!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                } else if (c == '-') {
                    if (!leftStack.isEmpty()) leftStack.pop();
                } else {
                    leftStack.push(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
            while (!rightStack.isEmpty()) {
                sb.append(rightStack.pop());
            }
            System.out.println(sb.toString());
        }
    }
}
