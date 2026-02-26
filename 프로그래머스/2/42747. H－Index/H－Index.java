import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // citations 오름차순 정렬 후
        // (n - 인덱스) >= citations[인덱스] -> 이 중에 가장 큰 값 구하기
                
        Arrays.sort(citations);
        int answer = 0;
        int n = citations.length;
        int tmp = n;
        
        int max = citations[n-1];        
        int idx = 0;
        for(int i=0; i<max; i++){
            // i <= citations[idx] && i <= tmp -> answer
            // citations[idx] < i -> idx++, tmp--
            
            if(n<=idx) break;
            while(citations[idx] < i && idx<n) {
                idx++;
                tmp--;
            }
            
            if(i<=citations[idx] && i<=tmp) answer = i;
        }
        
        return answer;
    }
}