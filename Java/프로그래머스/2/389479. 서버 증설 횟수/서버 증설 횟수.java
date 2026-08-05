class Solution {
    public int solution(int[] players, int m, int k) {
        int[] added = new int[24];
        int active = 0;
        int answer = 0;

        for (int i = 0; i < 24; i++) {
            if (i - k >= 0) active -= added[i - k]; // k시간 지난 서버 반납
            int needed = players[i] / m;
            if (active < needed) {
                int add = needed - active;
                added[i] = add;
                active += add;
                answer += add;
            }
        }
        return answer;
    }
}