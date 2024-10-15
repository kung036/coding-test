import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {        
        int answer = 0;
        int move = w*2+1;
        
        int idx = 0;
        int interval = 1;
        int start=0, end=0;
        int location = 1;
        
        while(location<=n) {
            if(idx<stations.length && stations[idx]-w<=location) {
                // 이미 설치된 기지국의 전파 도달 거리 안에 있는 경우
                location = stations[idx]+w+1;
                idx++;
            } else {
                // 새로 기지국을 설치해야하는 경우
                location += move;
                answer++;
            }            
        }
        
        return answer;
    }
}