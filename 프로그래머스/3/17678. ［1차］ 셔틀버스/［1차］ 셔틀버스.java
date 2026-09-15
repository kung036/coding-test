import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // 1. "HH:MM" → 분으로 변환 후 정렬
        int[] times = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            String[] parts = timetable[i].split(":");
            int h = Integer.parseInt(parts[0]);
            int mi = Integer.parseInt(parts[1]);
            times[i] = h * 60 + mi;
        }
        Arrays.sort(times);

        int idx = 0; // timetable에서 아직 안 태운 크루 포인터
        int lastBoardTime = -1; // 마지막 버스에 탄 마지막 크루의 도착 시각
        boolean lastBusFull = false;

        for (int busNum = 0; busNum < n; busNum++) {
            int busArrival = 9 * 60 + busNum * t; // 이번 버스 도착 시각(분)
            int boarded = 0;

            // 이 버스에 탈 수 있는 만큼(최대 m명) 태우기
            while (boarded < m && idx < times.length && times[idx] <= busArrival) {
                lastBoardTime = times[idx]; // 마지막으로 태운 크루의 도착 시각 갱신
                idx++;
                boarded++;
            }

            // 마지막 버스인 경우 상태 기록
            if (busNum == n - 1) {
                lastBusFull = (boarded == m);
            }
        }

        int lastBusArrival = 9 * 60 + (n - 1) * t;
        int answer;

        if (!lastBusFull) {
            // 자리가 남았다면 콘은 버스 도착 시각에 딱 맞춰 와도 됨
            answer = lastBusArrival;
        } else {
            // 꽉 찼다면 마지막으로 탄 사람보다 1분 일찍 와야 함
            answer = lastBoardTime - 1;
        }

        int h = answer / 60;
        int mi = answer % 60;
        return String.format("%02d:%02d", h, mi);
    }
}