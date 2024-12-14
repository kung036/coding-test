import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 차량별 누적시간 구하기
        // records : 시각(HH:MM, 00:00~23:59), 차량번호(0000~9999), 내역(IN, OUT)
        Map<String, int[]> map = new HashMap<>(); // 차량번호, [마지막 입차시간(분),누적시간]
        for(String record : records) {
            String[] recordSplit = record.split(" ");
            int time = Integer.valueOf(recordSplit[0].split(":")[0])*60 + Integer.valueOf(recordSplit[0].split(":")[1]);
            // recordSplit[0] : 시간(time)
            // recordSplit[1] : 차량번호
            // recordSplit[2] : IN or OUT
            
            if(recordSplit[2].equals("IN")) { // 입차된 차
                if(map.containsKey(recordSplit[1])) { // 이미 입차된 이력이 있는 차
                    int[] tmp = map.get(recordSplit[1]);
                    tmp[0] = time;
                    map.put(recordSplit[1], tmp);
                } else { // 새로 들어온 차
                    map.put(recordSplit[1], new int[]{time, 0});
                }
            } else { // 출차되는 차
                // 주차 시간 구하기
                int inTime = map.get(recordSplit[1])[0]; // 입차시간

                int[] tmp = map.get(recordSplit[1]);
                tmp[0] = -1;
                tmp[1] += time-inTime; // 누적 주차시간
                map.put(recordSplit[1], tmp);
            }
        }
        
        int n = map.size(); // 주차한 차량
        int lastTime = 1439; // 마지막 시간(23:59)
        int[] answer = new int[n];
        
        // 차량번호 오름차순
        String[] carNums = map.keySet().stream().sorted().toArray(String[]::new);
        
        // 주차요금 = 기본요금 + [(누적시간-기본시간) / 단위시간] * 단위요금        
        // fees : 기본시간(분), 기본요금, 단위시간(분), 단위요금
        for(int i=0; i<n; i++) {
            int fee = fees[1]; // 주차요금
            int time = map.get(carNums[i])[1]; // 주차 시간
            
            // 출차를 안한 경우
            if(map.get(carNums[i])[0] != -1) {
                time += (lastTime-map.get(carNums[i])[0]);
            }
            
            // 기본 시간이 넘은 경우
            if(time > fees[0]) {
                fee += Math.ceil((time-fees[0]) / (double)fees[2]) * fees[3];
            }
            answer[i] = fee;
        }
        
        return answer;
    }
}