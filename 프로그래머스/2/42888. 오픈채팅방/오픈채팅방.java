import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // uid별로 닉네임 저장
        // for문에서 record 돌면서 출력만 만들기
        
        int n = 0;
        Map<String, String> map = new HashMap<>();
        
        for(int i=0; i<record.length; i++) {
            String[] recordArr = record[i].split(" ");
            if(recordArr[0].equals("Enter")) map.put(recordArr[1], recordArr[2]);
            if(recordArr[0].equals("Change")) map.put(recordArr[1], recordArr[2]);
            if(recordArr[0].equals("Enter") || recordArr[0].equals("Leave")) n++;
        }
        
        String[] answer = new String[n];
        int j = 0;
        for(int i=0; i<record.length; i++) {
            String[] recordArr = record[i].split(" ");
            if(recordArr[0].equals("Enter")) answer[j++] = map.get(recordArr[1]) + "님이 들어왔습니다.";
            else if(recordArr[0].equals("Leave")) answer[j++] = map.get(recordArr[1]) + "님이 나갔습니다.";
        }
        
        return answer;
    }
}