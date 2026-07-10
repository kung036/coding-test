class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int total = toSec(video_len);
        int cur = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);

        // 시작 위치가 오프닝 구간이면 먼저 건너뜀
        if (cur >= opStart && cur <= opEnd) cur = opEnd;

        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                cur = Math.max(0, cur - 10);
            } else {
                cur = Math.min(total, cur + 10);
            }
            // 오프닝 건너뛰기
            if (cur >= opStart && cur <= opEnd) cur = opEnd;
        }

        return toStr(cur);
    }

    private int toSec(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60
             + Integer.parseInt(time.substring(3, 5));
    }

    private String toStr(int sec) {
        return String.format("%02d:%02d", sec / 60, sec % 60);
    }
}