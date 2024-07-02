import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt() - 45;
        
        // 45분 이상인 경우
        if(minute >= 0) ;
        else if(hour - 1 >= 0) {
            minute += 60; // 0시 이상인 경우
            hour -= 1;
        }
        else { // 0시 이하인 경우
            minute += 60;
            hour = 23;
        }
        System.out.println(hour + " " + minute);
    }
}