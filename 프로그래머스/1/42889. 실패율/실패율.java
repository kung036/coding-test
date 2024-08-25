import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // 실패율이 높은 스테이지(내림차순), 같을 경우에는 작은 번호가 먼저 옴
        // 스테이지에 도달한 유저가 없는 경우의 실패율 = 0
        // 1 <= stages <= N+1
        
        // stage 개수 : N
        double[] users = new double[N+2];
                
        // stage별 도달한 사용자수를 구함
        for(int i=0; i<stages.length; i++) { // O(N)
            users[stages[i]]++;
        }
        
        // 실패율 계산하기
        Map<Integer, Double> fails = new HashMap<>();
        int usersNum = stages.length;
        for(int i=1; i<=N; i++) {
            if(usersNum == 0) fails.put(i, 0.);
            else fails.put(i, users[i]/usersNum);
            usersNum -= users[i];
        }
        
        // 실패율을 내림차순으로 반환하기
        return fails.entrySet().stream()
            .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
            .mapToInt(HashMap.Entry::getKey)
            .toArray();
    }
}