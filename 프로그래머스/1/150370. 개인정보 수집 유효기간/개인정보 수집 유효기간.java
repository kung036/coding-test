import java.util.*;

class Solution {
    public int[] solution(String todays, String[] terms, String[] privacies) {
        // 약관별 유효기간 저장
        Map<String, Integer> map = new HashMap<>();
        int[] today = new int[3];
        today[0] = Integer.valueOf(todays.split("\\.")[0]);
        today[1] = Integer.valueOf(todays.split("\\.")[1]);
        today[2] = Integer.valueOf(todays.split("\\.")[2]);
        
        for(String term : terms) {
            int month = Integer.valueOf(term.split(" ")[1]);
            map.put(term.split(" ")[0], month);
        }
        
        // 만료일 계산
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<privacies.length; i++) {
            String privacie = privacies[i];
            int[] year = makeYear(privacie.split(" ")[0], map.get(privacie.split(" ")[1]));
            
            if(year[0]<today[0]) answer.add(i+1);
            else if(year[0]==today[0] && year[1]<today[1]) answer.add(i+1);
            else if(year[0]==today[0] && year[1]==today[1] && year[2]<today[2]) answer.add(i+1);
        }
        
        // 정답
        int[] ans = new int[answer.size()];
        for(int i=0; i<answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
    
    // 유효기간 계산
    public int[] makeYear(String receivedYear, int month) {
        // 개인정보 수집일자
        int[] year = new int[3];
        year[0] = Integer.valueOf(receivedYear.split("\\.")[0]);
        year[1] = Integer.valueOf(receivedYear.split("\\.")[1]);
        year[2] = Integer.valueOf(receivedYear.split("\\.")[2]);
        
        // 년
        year[0] += month/12;

        // 월
        month %= 12;
        year[1] += month;
        if(year[1] > 12) {
            year[1] -= 12;
            year[0]++;
        }
        
        // 일
        year[2]--;
        if(year[2] == 0) {
            year[1]--;
            year[2] = 28;
        }
        if(year[1] == 0) {
            year[1] = 12;
            year[0]--;
        }

        System.out.println(Arrays.toString(year));
        
        return year;
    }
}