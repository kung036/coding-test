import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        // set에 words를 하나씩 넣음
        // set에 words가 있는 단어거나 이전 단어의 끝알파벳으로 시작하지 않은 경우 번호와 차례를 구해서 게임 종료
        // set에 words에 있는 단어가 없다면 그대로 종료
        
        int[] answer = new int[]{0, 0};
        Set<String> set = new HashSet<>();
        
        int finish = -1;
        char ch = words[0].toCharArray()[0]; // 단어의 마지막 알파벳
        for(int i=0; i<words.length; i++) {
            if(set.contains(words[i])) { // 이전에 말했던 단어
                finish = i+1;
                break;
            }
            // 이전 단어의 마지막 알파벳과 지금 단어의 첫 알파벳이 다른 경우
            if(ch != words[i].toCharArray()[0]) {
                finish = i+1;
                break;
            }
            
            ch = words[i].toCharArray()[words[i].length()-1];
            set.add(words[i]);
        }

        if(finish != -1) {
            if(finish % n == 0) {
                answer[0] = n;
                answer[1] = finish / n;
            } else {
                answer[0] = finish % n;
                answer[1] = finish / n + 1;
            }
        }
        

        return answer;
    }
}