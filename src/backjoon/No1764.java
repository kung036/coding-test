package backjoon;

import java.util.*;

// 듣보잡
public class No1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<String> listen = new ArrayList<>();
        List<String> watch = new ArrayList<>();
        while(N-- > 0) {
            listen.add(sc.next());
        }
        while(M-- > 0) {
            watch.add(sc.next());
        }

        watch.retainAll(listen);
        System.out.println(watch.size());
        watch.stream().forEach(System.out::println);
    }
}
