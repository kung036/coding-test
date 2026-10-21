class Solution {
    public int[] solution(int e, int[] starts) {
        int[] cnt = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                cnt[j]++;
            }
        }

        int[] best = new int[e + 2];
        best[e] = e;
        for (int i = e - 1; i >= 1; i--) {
            best[i] = (cnt[i] >= cnt[best[i + 1]]) ? i : best[i + 1];
        }

        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = best[starts[i]];
        }
        return answer;
    }
}