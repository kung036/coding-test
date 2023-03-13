package backjoon;

import java.io.*;
import java.util.*;

// 싸이버개강총회
public class No91583 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기
        String[] time = br.readLine().split(" "); // 시간

        Set<String> startStudent = new HashSet<>(); // 00:00 ~ start 사이 시간에 채팅을 남긴 학생을
        Set<String> finishStudent = new HashSet<>(); // finish ~ streamingFinish 사이 시간에 채팅을 남긴 학생을

        String tmp = "";
        while((tmp = br.readLine()) != null) {
            String commentTime = tmp.split(" ")[0];
            String name = tmp.split(" ")[1];

            // 00:00 ~ start 사이 시간에 채팅을 남긴 학생을 ArrayList인 start에 추가하기
            if(time[0].compareTo(commentTime) >= 0) {
                startStudent.add(name);
            } else if(commentTime.compareTo(time[1]) >= 0 && time[2].compareTo(commentTime) >= 0) {
                // finish ~ streamingFinish 사이 시간에 채팅을 친 학생 중 start에 포함된 학생이면 구하려는 학생수 count 수 증가하기
                if(startStudent.contains(name)) {
                    finishStudent.add(name);
                }
            }
        }

        startStudent.retainAll(finishStudent);
        System.out.println(startStudent.size());
    }
}