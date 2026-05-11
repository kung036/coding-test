public class Solution {
    public int solution(int n) {
        int answer = n;
        int count = Integer.bitCount(n);

        while (Integer.bitCount(++answer) != count) {
        }

        return answer;
    }
}