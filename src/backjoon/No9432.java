package backjoon;

import java.util.*;
import java.io.*;

// 염색체
public class No9432 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.valueOf(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < count; i++) {
            String testCase = br.readLine(); // 테스트 케이스
            String regex = "[A-F]?A+F+C+[A-F]?"; // 염색체 특징

            if(testCase.matches(regex)) System.out.println("Infected!");
            else System.out.println("Good");
        }
    }
}

//package backjoon;
//
//import java.util.*;
//import java.io.*;
//
//// 염색체
//public class No9432 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int count = Integer.valueOf(br.readLine()); // 테스트 케이스 개수
//        char[] pattern = new char[] {'A', 'F', 'C'}; // A - F - C 순서 패턴
//
//        for(int i=0; i<count; i++) { // 테스트 케이스 개수만큼 반복
//            boolean[] patternCheck = new boolean[3]; // pattern의 방문 여부
//            int patternNum = 0; // 현재 pattern의 순서
//            boolean answer = true; // 현재 테스트 케이스가 염색체의 특정 패턴을 만족하는 여부
//
//            String testCase = br.readLine(); // 문자열
//            int finalStringIndex = testCase.length() - 1; // 마지막 문자열의 인덱스 번호
//
//            // 테스트 케이스가 염색체의 특정 패턴인지 확인하기
//            if('F' < testCase.charAt(0)) answer = false; // 첫번째 문자 확인
//            else if('F' < testCase.charAt(finalStringIndex)) answer = false; // 마지막 문자 확인
//            else {
//                if('A' == testCase.charAt(0)) patternCheck[0] = true; // 첫번째 문자 확인
//                if('C' == testCase.charAt(finalStringIndex)) patternCheck[2] = true; // 마지막 문자 확인
//
//                // A - F - C 순으로 되어 있는지 TestCase를 순회하면서 확인하기
//                for(int j=1; j<finalStringIndex; j++) {
//                    char ch = testCase.charAt(j);
//
//                    if(ch != pattern[patternNum]) {
//                        if(!patternCheck[patternNum] || patternNum == 2 || ch != pattern[patternNum+1]) {
//                            answer = false;
//                            break;
//                        } else {
//                            patternNum++;
//                            patternCheck[patternNum] = true;
//                        }
//                    } else patternCheck[patternNum] = true;
//                }
//
//                // A - F - C 패턴을 모두 방문했는지 확인하기
//                if(!patternCheck[0] || !patternCheck[1] || !patternCheck[2])
//                    answer = false;
//            }
//
//            if(answer) System.out.println("Infected!");
//            else System.out.println("Good");
//        }
//    }
//}