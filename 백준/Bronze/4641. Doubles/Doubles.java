// 6번 시도 : 20분
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int next = sc.nextInt();

        while(next != -1) {
            List<Integer> list = new ArrayList<>();
            int count = 0;
            while(next != 0) {
                list.add(next);
                next = sc.nextInt();
            }

            list = list.stream().sorted().collect(Collectors.toList());
            // 개수 확인
            for(int i=0; i<list.size()-1; i++) {
                int curInt = list.get(i);
                for(int j=i+1; j<list.size(); j++) {
                    if(curInt*2 == list.get(j)) {
                        count++;
                        break;
                    }
                }
            }
            next = sc.nextInt();
            System.out.println(count);
        }
    }
}