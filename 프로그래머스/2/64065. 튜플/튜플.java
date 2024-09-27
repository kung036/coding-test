import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        // s를 {}로 나누기
        // 개수를 기준으로 오름차순 정렬
        // 
        s = s.substring(2, s.length()-2); // 처음과 끝의 {} 제거
        List<List<Integer>> list = new ArrayList<>(); // int[]을 순서대로 저장
        
        // {}별로 나누기
        int index = 0;
        for(String split : s.split("},\\{")) {
            List<Integer> tuple = Arrays.stream(split.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
            list.add(tuple);
        }
        list.sort((o1, o2) -> Integer.compare(o1.size(), o2.size()));
        
        // 튜플 구하기
        List<Integer> answer = new ArrayList<>();
        List<Integer> before = list.get(0);
        List<Integer> now = list.get(0);
        answer.add(before.get(0));
        for(int i=1; i<list.size(); i++) {
            before = list.get(i-1);
            now = new ArrayList<>(list.get(i));
            now.removeAll(before);
            answer.add(now.get(0));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}