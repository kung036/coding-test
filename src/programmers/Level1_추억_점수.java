package programmers;

import java.util.*;

// 추억 점수
class Level1_추억_점수 {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

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
                sum += Optional.ofNullable(nameAndYearning.get(n)).orElse(0);
            }
            answer[i++] = sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}};
        int[] answer = solution(name, yearning, photo);
        System.out.println(Arrays.toString(answer));
    }
}