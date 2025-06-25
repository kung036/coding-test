import java.util.*;
import java.util.stream.*;

class Node {
    int idx;
    int value;
    
    Node(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}

class Solution {
    public int[] solution(int[] emergency) {
        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<emergency.length; i++) {
            Node n = new Node(i, emergency[i]);
            nodes.add(n);
        }
        
        nodes = nodes.stream().sorted((o1, o2) -> Integer.compare(o2.value, o1.value))
                    .collect(Collectors.toList());
        
        int[] answer = new int[emergency.length];
        for(int i=0; i<emergency.length; i++) {
            answer[nodes.get(i).idx] = i+1;
        }
        
        return answer;
    }
}