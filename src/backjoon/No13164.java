package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int kid = Integer.parseInt(tmp[0]);
        int group = Integer.parseInt(tmp[1]);

        int[] height = Arrays.stream(br.readLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();

        if(kid == group) {
            System.out.println(0);
            return ;
        }

        int cost = 0;

        List<Integer> list = new ArrayList<>();
        for(int i=1; i<kid; i++) {
            list.add(height[i] - height[i-1]);
        }

        Collections.sort(list);

        for(int i=0; i<kid-group; i++) {
            cost += list.get(i);
        }

        System.out.println(cost);
    }
}