// 4번 시도 : 23분
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        for(int i=0; i<count; i++) {
            int floor = sc.nextInt();
            int room = sc.nextInt();
            int customer = sc.nextInt();

            if(customer%floor != 0) {
                room = customer/floor + 1;
                floor = customer%floor;
            } else {
                room = customer/floor;
                floor = floor;
            }
            if(room < 10) System.out.println(floor + "0" + room);
            else System.out.println(floor + "" + room);
        }
    }
}