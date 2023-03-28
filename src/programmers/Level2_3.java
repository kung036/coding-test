package programmers;

import java.util.Arrays;

// 광물 캐기
public class Level2_3 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] picks = {1, 3, 2};
        String[] minerals = new String[]{
                "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"
        };

        int answer = s.solution(picks, minerals);
        System.out.println("answer : " + answer); // 7

        int[] picks2 = {0, 1, 1};
        String[] minerals2 = new String[]{
                "diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"
        };
        answer = s.solution(picks2, minerals2);
        System.out.println("answer : " + answer); // -1
    }

    static class Solution {
        public int solution(int[] picks, String[] minerals) {
            int answer = 0;

            int len = minerals.length;
            int all_picks = picks[0] + picks[1] + picks[2];
            if(len > all_picks*5) len = all_picks * 5;
            else all_picks = len%5 == 0 ? len/5 : len/5+1;

            int[] diamond = new int[all_picks];
            int[] iron = new int[all_picks];
            int[] stone = new int[all_picks];
            boolean[] visited = new boolean[all_picks];

            int k = -1;
            for(int i=0; i<len; i++) {
                if(i%5 == 0) k++;
                if(minerals[i].equals("diamond")) {
                    diamond[k] += 1;
                    iron[k] += 5;
                    stone[k] += 25;
                } else if(minerals[i].equals("iron")) {
                    diamond[k] += 1;
                    iron[k] += 1;
                    stone[k] += 5;
                } else {
                    diamond[k] += 1;
                    iron[k] += 1;
                    stone[k] += 1;
                }
            }

            k = 0;
            while(true) {
                while(picks[k] != 0) {
                    int index = 0;
                    if(k == 0) {
                        index = max_index(visited, iron);
                        answer += diamond[index];
                    }
                    else if(k == 1) {
                        index = max_index(visited, stone);
                        answer += iron[index];
                    }
                    else if(k == 2) {
                        index = min_index(visited, stone);
                        answer += stone[index];
                    }

                    visited[index] = true;
                    picks[k]--;
                    if(visit(visited)) break;
                }

                if(!visit(visited)) k++;
                else break;
            }

            return answer;
        }

        public int max_index(boolean[] visited, int[] picks_prio) {
            int max = -1;
            int index = 0;

            for(int i=0; i<picks_prio.length; i++) {
                if(!visited[i] && (max < picks_prio[i])) {
                    index = i;
                    max = picks_prio[i];
                }
            }

            return index;
        }
        public int min_index(boolean[] visited, int[] picks_prio) {
            int min = 100;
            int index = 0;

            for(int i=0; i<picks_prio.length; i++) {
                if(!visited[i]) {
                    index = i;
                    if(min > picks_prio[i]) {
                        index = i;
                        min = picks_prio[i];
                    }
                }
            }

            return index;
        }

        public boolean visit(boolean[] visited) {
            for(int i=0; i<visited.length; i++) {
                if(!visited[i]) return false;
            }

            return true;
        }
    }
}
