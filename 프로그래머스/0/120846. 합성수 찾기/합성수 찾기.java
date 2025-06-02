class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=4; i<=n; i++) {
            int tmp = 0;
            for(int j=1; j<i; j++) {
                if(i%j == 0) tmp++;
                // System.out.println(i + " " + j);
            }
            // System.out.println(tmp);
            if(tmp >= 2) answer++;
        }
        
        return answer;
    }
}