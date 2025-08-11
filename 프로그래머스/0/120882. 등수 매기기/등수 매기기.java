import java.util.*;

class Solution {
    class Node {
        double score;
        int idx;
        int sort;
        
        Node(double score, int idx) {
            this.score = score;
            this.idx = idx;
        }
    }
    
    public int[] solution(int[][] score) {
        int n = score.length;
        int[] answer = new int[n];
        
        // node 변환
        List<Node> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new Node((score[i][0]+score[i][1])/2.0, i+1));
        }
        
        // 점수 정렬(내림차순)
        list.sort((o1, o2) -> Double.compare(o2.score, o1.score));
        
        // 등수 세기
        int s = 1;
        double tmp = list.get(0).score;
        for(int i=0; i<n; i++) {
            if(tmp != list.get(i).score) {
                s = i+1;
                tmp = list.get(i).score;
            }
            list.get(i).sort = s;
        }
        
        return list.stream()
                    .sorted((o1, o2) -> Integer.compare(o1.idx, o2.idx))
                    .mapToInt(o -> o.sort)
                    .toArray();
    }
}