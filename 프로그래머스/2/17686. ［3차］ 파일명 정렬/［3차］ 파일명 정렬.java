import java.util.*;

class Node {
    int index;
    String head;
    int num;
}

class Solution {
    public String[] solution(String[] files) {
        // index, head, number로 분리
        // 이때 head는 대문자로 만들기
        
        int n = files.length;
        String[] answer = new String[n];
        Node[] nodes = new Node[n];
        
        for(int i=0; i<n; i++) {
            nodes[i] = new Node();
            nodes[i].index = i;
            
            char[] arr = files[i].toCharArray();
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            while(true) { // head 구하기
                int at = Integer.valueOf(arr[idx]);
                
                if(48 <= at && at <= 57) {
                    nodes[i].head = sb.toString().toUpperCase();
                    break;
                } else {
                    sb.append(arr[idx]);
                    idx++;
                }
            }
            
            sb = new StringBuilder();
            while(true) { // number 구하기
                if(idx>=files[i].length()) {
                    nodes[i].num = Integer.valueOf(sb.toString());
                    break;
                }
                
                int at = Integer.valueOf(arr[idx]);
                if(48 <= at && at <= 57) {
                    sb.append(arr[idx]);
                    idx++;
                } else {
                    nodes[i].num = Integer.valueOf(sb.toString());
                    break;
                }
            }
        }

        // 정렬
        Arrays.sort(nodes, (o1, o2) -> {
            if(o1.head.equals(o2.head)) {
                return Integer.compare(o1.num, o2.num);
            } else return o1.head.compareTo(o2.head);
        });
        
        // 정답 반환
        for(int i=0; i<n; i++) {
            answer[i] = files[nodes[i].index];
        }
        
        return answer;
    }
}