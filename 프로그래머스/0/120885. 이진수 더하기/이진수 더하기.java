class Solution {
    public String solution(String bin1, String bin2) {
        int i1 = Integer.valueOf(bin1, 2);
        int i2 = Integer.valueOf(bin2, 2);
        return Integer.toBinaryString(i1 + i2);
    }
}