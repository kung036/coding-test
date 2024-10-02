class Solution {
    public int[] solution(String s) {
        int removeZero = 0; // 제거한 0의 개수
        int cnt = 0; // "1"이 될까지 이진 변환 횟수
        int n = s.length();
        
        // "1"이 될때까지 이진 변환 진행
        while(!s.equals("1")) {
            s = s.replace("0", "");
            removeZero += n-s.length();
            s = Integer.toBinaryString(s.length());
            cnt++;
            n = s.length();
        }
        
        return new int[]{cnt, removeZero};
    }
}