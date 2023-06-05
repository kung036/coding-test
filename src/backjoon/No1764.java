package backjoon;

import java.util.*;

// 듣보잡
public class No1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

       Map<String, Integer> map = new HashMap<>();
       List<String> list = new ArrayList<>();

       while(N-->0) {
           map.put(sc.next(), 1);
       }
       while(M-->0) {
           String name = sc.next();
           map.put(name, map.getOrDefault(name,0) +  1);
           if(map.get(name) == 2) list.add(name);
       }

       System.out.println(list.size());
       list.stream().sorted().forEach(System.out::println);

    }
}
