// 2번 시도 : 10분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int month = Integer.parseInt(input[0]); // 월
        int day = Integer.parseInt(input[1]); // 일
        
        // 요일
        String[] weeks = {
            "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"
        };
        
        // 월별 날짜
        int[] monthDays = {
            31, 28, 31, 30, 31, 30, 
            31, 31, 30, 31, 30, 31
        };
        
        int days = 0;
        for(int i=0; i<(month-1); i++) {
            days += monthDays[i];
        }
        days += day;
        
        System.out.println(weeks[days%7]);
    }
}