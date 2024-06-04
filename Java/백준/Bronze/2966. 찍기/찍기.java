// 6번 시도 : 21분
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 상근이 ABC
        char[] pattern1 = new char[] { 'A', 'B', 'C' };
        int p1_len = pattern1.length;
        // 창영이 BABC
        char[] pattern2 = new char[] { 'B', 'A', 'B', 'C' };
        int p2_len = pattern2.length;
        // 현진이 CCAABB
        char[] pattern3 = new char[] { 'C', 'C', 'A', 'A', 'B', 'B' };
        int p3_len = pattern3.length;
        
        // 맞힌 문제 개수
        int max = 0;
        int[] sum = new int[3];
        
        // 입력
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(); // 문제 길이
        String problem = sc.next(); // 문제
        
        for(int i=0; i<len; i++) {
            char c = problem.charAt(i);
            
            if(c == pattern1[i%p1_len]) sum[0]++;
            if(c == pattern2[i%p2_len]) sum[1]++;
            if(c == pattern3[i%p3_len]) sum[2]++;
        }
        
        // 가장 많이 맞힌 사람
        String[] names = new String[] {
            "Adrian", "Bruno", "Goran"
        };
        if(sum[0] >= sum[1]) max = sum[0];
        else max = sum[1];
        if(max < sum[2]) max = sum[2];
        
        System.out.println(max);
        for(int i=0; i<names.length; i++) {
            if(sum[i] == max) System.out.println(names[i]);
        }
    }
}