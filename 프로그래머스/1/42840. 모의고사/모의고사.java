import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] collectNum = new int[4]; // 각 학생의 문제를 맞춘 횟수
        
        // 1번 방식 : 1~5 반복
        // 2번 방식 : 21 23 24 25 반복
        // 3번 방식 : 3 1 2 4 5 각 2번씩 반복
        int[] student1 = new int[] {1, 2, 3, 4, 5};
        int[] student2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        
        // 정답 개수 확인 : collectNum에 각 학생의 정답 횟수 넣기
        // 학생들의 정답 리스트를 통해서 정답 확인하기
        for(int i=0; i<answers.length; i++) {
            if(student1[i%student1.length] == answers[i]) collectNum[1]++;
            if(student2[i%student2.length] == answers[i]) collectNum[2]++;
            if(student3[i%student3.length] == answers[i]) collectNum[3]++;
        }
        
        // 정답 출력하기
        // 가장 많이 맞춘 학생 출력
        int maxCount = Math.max(collectNum[1], Math.max(collectNum[2], collectNum[3])); // 많이 맞춘 문제수
        List<Integer> answer = new ArrayList<>();
        if(collectNum[1] == maxCount) answer.add(1);
        if(collectNum[2] == maxCount) answer.add(2);
        if(collectNum[3] == maxCount) answer.add(3);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}