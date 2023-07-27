package programmers;

import java.util.*;

// 달리기 경주

class Level1_달리기_경주 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players.clone();
        Map<String, Integer> names = new HashMap<>();
        Map<Integer, String> counts = new HashMap<>();

        // map 초기화
        for(int i=0; i<answer.length; i++) {
            names.put(answer[i], i);
            counts.put(i, answer[i]);
        }

        // callings를 이용해서 경주가 끝난 후 선수의 순위 구하기
        String tmp;
        Integer count;
        for(String name : callings) {
            count = names.get(name); // 역전하기 전 순위
            tmp = counts.get(count-1); // 역전당한 선수의 이름

            // 역전된 상황에 맞추어 값 변경하기
            names.replace(name, count-1);
            names.replace(tmp, count);
            counts.replace(count, tmp);
            counts.replace(count-1, name);
        }

        // answer 구하기
        for(int i=0; i<answer.length; i++) {
            answer[i] = counts.get(i);
        }

        return answer;
    }
}