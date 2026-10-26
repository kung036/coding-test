class Solution {
    public int solution(String[] lines) {
        int n = lines.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            String[] p = lines[i].split(" ");
            String[] t = p[1].split(":");
            String[] sec = t[2].split("\\.");
            int endMs = (Integer.parseInt(t[0]) * 3600 + Integer.parseInt(t[1]) * 60 + Integer.parseInt(sec[0])) * 1000
                    + Integer.parseInt(sec[1]);
            int dur = (int) Math.round(Double.parseDouble(p[2].replace("s", "")) * 1000);
            end[i] = endMs;
            start[i] = endMs - dur + 1; // 시작/끝 시간 모두 포함
        }

        int answer = 0;
        // 최대 처리량 구간은 어떤 요청의 시작 또는 끝 시각에서 시작하는 1초 구간에서 나온다.
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, count(start, end, start[i]));
            answer = Math.max(answer, count(start, end, end[i]));
        }
        return answer;
    }

    // 구간 [t, t + 999]와 겹치는 요청 수
    private int count(int[] start, int[] end, int t) {
        int limit = t + 999;
        int cnt = 0;
        for (int j = 0; j < start.length; j++) {
            if (start[j] <= limit && end[j] >= t) cnt++;
        }
        return cnt;
    }
}