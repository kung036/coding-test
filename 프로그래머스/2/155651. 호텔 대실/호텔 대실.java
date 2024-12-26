import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 시간이 작은 순으로 정렬
        Arrays.sort(book_time, (o1, o2) -> {
            if(!o1[0].equals(o2[0])) return o1[0].compareTo(o2[0]);
            else return o1[1].compareTo(o2[1]);
        });
        
        // 우선순위 큐(낮은거부터 나옴)
        Queue<String> q = new PriorityQueue<>();
        
        // 큐의 크기를 매순간 재기        
        int answer = 0;
                
        for(String[] time : book_time) {
            // 다음 입장 가능한 시간
            String[] nextTime = time[1].split(":");
            int hour = Integer.valueOf(nextTime[0]);
            int min = Integer.valueOf(nextTime[1]) + 10;
            if(min >= 60) {
                hour++;
                min -= 60;
            }
            String strHour = hour<10 ? "0"+hour+":" : hour+":";
            String t = min<10 ? strHour+"0"+min : strHour+min;
            
            // 입실 가능한 경우
            if(!q.isEmpty() && q.peek().compareTo(time[0]) <= 0) {
                q.poll();
            }
            q.add(t);
            
            answer = Math.max(answer, q.size());
            // System.out.println(q);
        }
        
        return answer;
    }
}