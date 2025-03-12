class Solution {
    public int solution(int a, int b) {
        int answer1 = Integer.valueOf(a + "" + b);
        int answer2 = 2 * a * b;
        return Math.max(answer1, answer2);
    }
}