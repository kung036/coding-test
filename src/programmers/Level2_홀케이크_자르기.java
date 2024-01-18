package programmers;
import java.util.*;

public class Level2_홀케이크_자르기 {
    class Solution {
        public int solution(int[] topping) {
            int answer = 0;

            // 예외) topping의 길이가 1인 경우 -> 공평하게 나눌 방법 X
            if(topping.length == 1) return answer;

            // 1. i의 길이가 왼쪽 롤케이크의 토핑의 개수라고 가정, 왼쪽 오른쪽 롤케이크의 토핑읠 담을 Map 자료형 선언하기
            Map<Integer, Integer> left = new HashMap<>();
            Map<Integer, Integer> right = new HashMap<>();

            // 2. 오른쪽 롤케이크에 모든 토핑 추가
            for(int i=0; i<topping.length; i++) {
                right.put(topping[i], right.getOrDefault(topping[i], 0)+1);
            }

            // 3. 0부터 (topping길이 - 1) 만큼 for문 돌기
            for(int i=0; i<topping.length-1; i++) {
                // 4. 기준값 설정
                int standard = topping[i];

                // 5. Map 자료형으로 나눠진 롤케이크의 토핑 개수 담기
                // key = topping 종류, value = topping 개수

                // 5-1. 왼쪽은 기준 토핑(topping[i]) 추가
                left.put(standard, left.getOrDefault(standard, 0)+1);
                // 5-2. 오른쪽에는 기준 토핑(topping[i]) 제거
                if(right.get(standard) == 1) right.remove(standard);
                else right.put(standard, right.get(standard)-1);

                // 6. 두 set의 길이가 같으면 answer++
                if(left.size() == right.size()) {
                    answer++;
                    // System.out.println(i);
                    // System.out.println(left);
                    // System.out.println(right);
                }
            }

            return answer;
        }
    }
}
