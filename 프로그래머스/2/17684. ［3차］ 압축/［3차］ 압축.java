import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 사전의 색인 번호(A : 65, Z : 90)
        Map<String, Integer> map = new HashMap<>();
        char A = 65;
        for(int i=0; i<26; i++) {
            char next = (char)(A+i);
            map.put(String.valueOf(next), i+1);
        }
        System.out.println(map);
        
        // 압축 인덱스
        List<Integer> answer = new ArrayList<>();
        int idx = 27; // 새로운 색인 번호
        String w = "" + msg.charAt(0); // 현재 입력
        for(int i=1; i<msg.length(); i++) {
            // 1. 만약 있는 단어인 경우 : answer에 추가하기
            // 있는 단어에 이어서 단어 붙이기
            // 2. 없는 단어인 경우 : 이어진 단어를 인덱스 추가
            // 이어진 단어 (n-1)(n)을 각각 단어에 넣기
                        
            if(!map.containsKey(w+msg.charAt(i))) {
                answer.add(map.get(w));
                map.put(w+msg.charAt(i), idx++);
                w = "" + msg.charAt(i);
            } else w += msg.charAt(i);
        }
        answer.add(map.get(w));
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}