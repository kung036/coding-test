class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int move = n-1;
        
        for(int i=0; i<n; i++) {
            char c = name.charAt(i);
            
            // 좌우 이동
            int nextIndex = i + 1;
            while (nextIndex < n && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            // 좌우 이동 최소값을 계산
            move = Math.min(move, i + n - nextIndex + Math.min(i, n - nextIndex));
            
            // 글자 조작
            // abcdefghij k l m  n o p q rstuvwxyz
            //  123456789101112  13121110987654321
            if(c <= 'M') answer += (c - 'A');
            else answer += (Math.abs(c-'Z') + 1);
        }
        
        answer += move;
        
        return answer;
    }
}