import java.util.*;
import java.util.stream.Collectors;

class Solution {
    Map<String, List<String>> map = new HashMap<>();
    List<String> list = new ArrayList<>();
    List<String> answer;
    boolean find = false;
    int n;

    public String[] solution(String[][] tickets) {
        // 출발지와 목적지가 모인 map 구현
        for(String[] ticket : tickets) {
            if(!map.containsKey(ticket[0])) {
                map.put(ticket[0], new ArrayList<>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        
        // 도착지 오름차순 정렬
        for(String c : map.keySet()) {
            map.put(c, map.get(c).stream().sorted().collect(Collectors.toList()));
        }
        
        // DFS를 이용해서 경로 설정
        n = tickets.length+1;
        list.add("ICN");
        dfs("ICN");
        
        return answer.toArray(new String[0]);
    }
    
    public void dfs(String start) {
        if(list.size() == n) {
            if(answer == null) answer = new ArrayList<>(list);
            return; // 모든 도시에 방문한 경우
        }
        
        if(map.get(start) == null) return; // 출발지가 아닌 도시
        
        for(int i=0; i<map.get(start).size(); i++) {
            if(map.get(start).get(i).equals("-1")) continue;

            String next = map.get(start).get(i);
            map.get(start).set(i, "-1");
            list.add(next);
            dfs(next);
            list.remove(list.size()-1);
            map.get(start).set(i, next);
        }
    }
}