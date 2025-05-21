class Solution {
    public int solution(int num, int k) {
        String s = num + "";
        String sk = k + "";
        return s.indexOf(sk) < 0 ? -1 : s.indexOf(sk)+1;
    }
}