import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // people 오름차순 정렬
        Arrays.sort(people);
        int i = 0; // 무게가 가장 작은 사람의 인덱스
        int j = people.length-1; // 무게가 가장 큰 사람의 인덱스
        
        int answer = 0;
        while(i<=j) {
            if(people[i]+people[j] <= limit) {
                i++;
            }
            
            j--;
            answer++;
        }
        
        return answer;
    }
}