class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int newCola = (n / a) * b; // 이번에 받을 콜라
            answer += newCola;
            n = (n % a) + newCola; // 남은 빈 병 + 새로 마신 콜라의 빈 병
        }
        return answer;
    }
}
