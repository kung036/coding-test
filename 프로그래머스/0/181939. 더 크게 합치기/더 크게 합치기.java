class Solution {
    public int solution(int a, int b) {
        int sum1 = Integer.valueOf(a + "" + b);
        int sum2 = Integer.valueOf(b + "" + a);
        return Math.max(sum1, sum2);
    }
}