import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answers = new int[numbers.length * numbers.length]; // 초기화

        // 0인 수 확인하기
        int count = 0;
        
        // 모든 경우의 수 구하기
        int index = 0;
        for(int i=0; i<numbers.length-1; i++) {
            if(numbers[i] == 0) count++; // 0의 개수 세기
            for(int j=i+1; j<numbers.length; j++) {
                answers[index++] = numbers[i] + numbers[j];
            }
        }
        
        // 중복 제거 후 오름차순 정렬
        if(count >= 2) { // 0이 2개 이상인 경우에만 0 출력
            return Arrays.stream(answers)
            .distinct()
            .sorted()
            .toArray();
        }
        
        return Arrays.stream(answers)
            .distinct()
            .filter(o -> o != 0)
            .sorted()
            .toArray();
    }
}