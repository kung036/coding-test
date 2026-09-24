class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = toSec(play_time);
        int adv = toSec(adv_time);

        long[] cnt = new long[play + 2];
        for (String log : logs) {
            String[] p = log.split("-");
            cnt[toSec(p[0])]++;
            cnt[toSec(p[1])]--;
        }

        // 초별 시청자 수
        for (int i = 1; i <= play; i++) {
            cnt[i] += cnt[i - 1];
        }

        // 첫 윈도우 [0, adv)
        long sum = 0;
        for (int i = 0; i < adv; i++) {
            sum += cnt[i];
        }

        long max = sum;
        int start = 0;

        // 윈도우 슬라이딩
        for (int i = adv; i < play; i++) {
            sum += cnt[i] - cnt[i - adv];
            if (sum > max) {
                max = sum;
                start = i - adv + 1;
            }
        }

        return toTime(start);
    }

    private int toSec(String t) {
        String[] s = t.split(":");
        return Integer.parseInt(s[0]) * 3600
             + Integer.parseInt(s[1]) * 60
             + Integer.parseInt(s[2]);
    }

    private String toTime(int sec) {
        return String.format("%02d:%02d:%02d", sec / 3600, (sec % 3600) / 60, sec % 60);
    }
}