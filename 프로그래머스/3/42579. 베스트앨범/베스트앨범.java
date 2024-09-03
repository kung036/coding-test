import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // Map -> 장르와 {노래 횟수1, index1, 노래 횟수2, index2}
        // 이때 넣는 기준은 가장 많이 재생된 2곡
        // for문을 돌면서 비교문을 통해서 업데이트함
        
        Map<String, int[]> playlist = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            if(playlist.containsKey(genres[i])) { // 수록된 경우
                int[] play = playlist.get(genres[i]);
                if(play[0] < plays[i]) { // play[0] 대체 & play[0]이 play[2]로 이동
                    play[2] = play[0];
                    play[3] = play[1];
                    play[0] = plays[i];
                    play[1] = i;
                } else if(play[2] < plays[i]) { // play[2] 대체
                    play[2] = plays[i];
                    play[3] = i;
                }
                play[4] += plays[i];
                // System.out.println(Arrays.toString(play));
                playlist.put(genres[i], play);
            } else { // 수록되지 않은 경우
                int[] play = {plays[i], i , -1, -1, plays[i]}; // 없는 값은 -1 처리
                playlist.put(genres[i], play);
            }
        }
        
        // 저장된 playlist에서 최대값을 이용해서 sorting
        List<int[]> list = playlist.entrySet().stream()
            .sorted((o1, o2) -> Integer.compare(o2.getValue()[4], o1.getValue()[4]))
            .map(o -> o.getValue())
            .collect(Collectors.toList());
        
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            answer.add(list.get(i)[1]);
            if(list.get(i)[3] != -1) answer.add(list.get(i)[3]);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}