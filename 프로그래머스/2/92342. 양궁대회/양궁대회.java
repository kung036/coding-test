import java.util.*;

class Solution {
    int gap = 0; // 어피치와 라이언의 점수 차
    int[] rianSum = new int[11]; // 라이언 점수표
    int[] info; // 어피치 점수표
    int[] answer = { -1 };
    
    public int[] solution(int n, int[] info) {
        // 과녁 점수를 큰 순으로 선택하기

        // 어피치의 점수 구하기
        int sum = 0;
        for(int i=0; i<info.length; i++) {
            if(info[i] > 0) sum += (10-i);
        }
        
        this.info = info;
        dfs(0, n, sum, 0);
        
        return answer;
    }
    
    public void dfs(int index, int n, int apich, int rian) {
        // 어피치보다 라이언이 이긴 경우
        if(index == 11 || n == 0) {
            if(apich == rian) return;

            rianSum[10] += n;
            if(gap < (rian-apich)) { // 갭차이가 많이 나는 경우
                answer = rianSum.clone();
                gap = rian - apich;
            } else if(gap == (rian-apich)) { // 낮은 점수가 많은 것 선택
                for(int i=info.length-1; i>=0; i--) {
                    if(answer[i] < rianSum[i]) {
                        answer = rianSum.clone();
                        break;
                    } else if(answer[i] > rianSum[i]) break;
                }
            }
            rianSum[10] = 0;
            
            return;
        }
        
        for(int i=index; i<info.length; i++) {
            int point = 10-i; // 현재 과녁 점수
            if(info[i]<n) { // 남은 점수로 포인트를 선택할 수 있는 경우
                // 어피치가 화살을 맞추지 않은 경우
                if(info[i] == 0) {
                    rianSum[i] = 1;
                    dfs(i+1, n-1, apich, rian+point);
                } // 어피치가 화살을 맞춘 경우
                else {
                    rianSum[i] = 1+info[i];
                    dfs(i+1, n-1-info[i], apich-point, rian+point);
                }
                rianSum[i] = 0;
            }
            if(i == info.length-1) dfs(i+1, n, apich, rian);
        }
    }
}