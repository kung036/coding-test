class Solution {
    public int solution(int hp) {
        int answer = 0;
        int[] hps = new int[]{5, 3, 1};
        
        for(int i=0; i<hps.length; i++) {
            while(hp >= hps[i]) {
                answer++;
                hp -= hps[i];
            }
        }
        
        return answer;
    }
}