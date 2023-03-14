package programmers;

import java.util.*;
import java.io.*;

// 덧칠하기
public class Level2_1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 8;
        int m = 4;
        int[] section = new int[]{ 2, 3, 6 };

        int answer = s.solution(n, m, section);
        System.out.println("answer : " + answer); // 2

        n = 5;
        m = 4;
        int[] section2 = new int[]{ 1, 3 };
        answer = s.solution(n, m, section2);
        System.out.println("answer : " + answer); // 1

        n = 4;
        m = 1;
        int[] section3 = new int[]{ 1, 2, 3, 4 };
        answer = s.solution(n, m, section3);
        System.out.println("answer : " + answer); // 4
    }
}

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;

        int range = section[0] + m;

        for(int i=1; i<section.length; i++) {
            if(section[i] >= range) {
                range = section[i] + m;
                answer++;
            }
        }

        return answer;
    }
}