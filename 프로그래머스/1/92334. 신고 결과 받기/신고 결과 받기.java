import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        // id수
        int n = id_list.length;
        
        // Map<String, Set<String>> : 신고당한 ID - 신고한 ID들
        Map<String, Set<String>> banList = new HashMap<>();
            
        // 결과 보고받을 횟수 -> 신고당한 ID 값 길이가 key 이상일 경우
        Map<String, Integer> mailList = new HashMap<>();
        
        // 각 map에 id 추가
        for(int i=0; i<n; i++) {
            banList.put(id_list[i], new HashSet<>());
            mailList.put(id_list[i], 0);
        }
        
        // reports에서 신고당한 ID 및 신고한 ID 추가
        for(String report : reports) {
            String[] reportSplit = report.split(" ");
            banList.get(reportSplit[1]).add(reportSplit[0]);
        }
        
        // reportList 생성 -> reportSplit의 값길이가 key 이상일 경우
        // set에 있는 id별로 메일 받을 횟수 증가시키기
        banList.forEach((key, value) -> {
            if(value.size() >= k) { // 신고가 되는 경우
                value.forEach(o -> mailList.put(o, mailList.get(o)+1));
            }
        });
        
        // 메일 전송 횟수 구하기
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            answer[i] = mailList.get(id_list[i]);
        }
        
        return answer;
    }
}