import java.util.*;
import java.util.stream.Collectors;

class Solution {
    class Node {
        int time; // 재생시간
        String name; // 음악 제목
        String start; // 시작 시간
        
        Node(int time, String name, String start) {
            this.time = time;
            this.name = name;
            this.start = start;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        // 음 : C, C#, D, D#, E, F, F#, G, G#, A, A#, B (12개)
        // 일치하는 음악이 여러 개인 경우 : 재생시간이 제일 긴 음악
        // 둘다 일치하는 경우 : 먼저 입력된 음악
        // X : (None)
        
        // 시간을 map으로 만들기
        Map<String, List<Node>> map = new HashMap<>(); // key : 재생된 멜로디
        for(String music : musicinfos) {
            String[] musics = music.split(",");
            
            // node 정의하기 - 재생시간
            int bHour = Integer.valueOf(musics[0].split(":")[0]);
            int bMinute = Integer.valueOf(musics[0].split(":")[1]);
            int nHour = Integer.valueOf(musics[1].split(":")[0]);
            int nMinute = Integer.valueOf(musics[1].split(":")[1]);
            int time = (nHour-bHour)*60 + (nMinute - bMinute);            
            
            // node 정의하기 - 재생음악
            String melody = convertMelody(musics[3]);
            int repeat = (int) Math.ceil(time/melody.length());
            if(repeat > 0) melody = melody.repeat(repeat+1).substring(0, time);
            else melody = melody.substring(0, time);
            
            
            // node 정의
            Node n = new Node(time, musics[2], musics[0]);
            
            // map에 값 넣기
            if(!map.containsKey(melody)) {
                List<Node> list = new ArrayList<>();
                list.add(n);
                map.put(melody, list);
            } else map.get(melody).add(n);
        }
        
        // 조건을 만족하는 음악 구하기
        List<Node> list = new ArrayList<>();
        m = convertMelody(m);
        for(String melody : map.keySet()) {
            if(melody.contains(m)) {
                list.addAll(map.get(melody));
            }
        }
        
        // 조건을 만족하는 경우가 없는 경우
        if(list.isEmpty()) return "(None)";
        
        // 일치하는 음악이 여러 개인 경우 : 재생시간이 제일 긴 음악
        // 둘다 일치하는 경우 : 먼저 입력된 음악
        String answer = "(None)";
        
        List<Node> nodes = list.stream()
                    .sorted((o1, o2) -> {
                        if (o2.time != o1.time) return o2.time - o1.time; // 재생 시간 내림차순
                        return o1.start.compareTo(o2.start);             // 시작 시간 오름차순
                    })
                    .collect(Collectors.toList());
        
        if(!nodes.isEmpty()) answer = nodes.get(0).name;
        
        return answer;
    }
    
    public String convertMelody(String melody) {
        return melody.replace("C#", "c")
                     .replace("D#", "d")
                     .replace("F#", "f")
                     .replace("G#", "g")
                     .replace("B#", "b")
                     .replace("A#", "a");
    }
}