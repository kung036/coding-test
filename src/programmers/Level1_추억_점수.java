package programmers;

import java.util.*;

// 추억 점수
class Level1_추억_점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[name.length];

        // name과 yearning이 매핑된 map 선언
        Map<String, Integer> nameAndYearning = new HashMap<>();
        for(int i=0; i<name.length; i++) {
            nameAndYearning.put(name[i], yearning[i]);
        }

        // 그리움 계산하기
        int i = 0;
        for(String[] names : photo) {
            int sum = 0;
            for(String n : names) {
                sum += nameAndYearning.get(n);
            }
            answer[i++] = sum;
        }

        return answer;
    }
}