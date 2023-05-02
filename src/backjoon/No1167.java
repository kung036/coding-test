package backjoon;

import java.io.*;
import java.util.*;

public class No1167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int treeResult = 0;
        int count = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> tree = new HashMap<>();

        // 트리 구현
        while(count-- > 0) {
            int dot = Integer.parseInt(st.nextToken());
            tree.put(dot, new ArrayList<>());
            int num = Integer.parseInt(st.nextToken());
            while(num != -1) {
                int distance = Integer.parseInt(st.nextToken());
                tree.get(dot).add(num);
                tree.get(dot).add(distance);
                num = Integer.parseInt(st.nextToken());
            }
        }

        // 트리의 지름 구하기 - bfs
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(tree.get(0).get(0));
        Boolean[] visited = new Boolean[100001];
        visited[tree.get(0).get(0)] = true;
        int distance = 0;
        while(!stack.isEmpty()) {
            int currentDot = stack.pop();
            List<Integer> tmp = tree.get(currentDot);
            visited[currentDot] = true;
            max += distance;
            for(Integer dot : tmp) {
                stack.add(dot);
                if(dot == stack.peek()) distance = 5;
            }

            if(max > treeResult) treeResult = max;
            distance = 5;
        }

        System.out.println(treeResult);
    }
}