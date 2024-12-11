class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int idx = 0; // str의 순서
        int num = 0; // 현재 숫자
        String str = parseString(num, n); // 현재 숫자를 n진수로 변경
        int P = 1; // 현재 말하는 사람의 순서
                
        while(0<t) {
            if(P == p) { // 자신의 차례인 경우
                answer += str.charAt(idx);
                t--;
            }
            
            // str를 전부 순회하는 경우
            idx++;
            if(P == m) P = 1;
            else P++;
            if(idx == str.length()) {
                str = parseString(++num, n);
                idx = 0;
            }
        }
        
        return answer;
    }
    
    public String parseString(int num, int n) {
        return Integer.toString(num, n).toUpperCase();
    }
}