package programmers;

import java.util.*;

// 등산코스 정하기
public class Level3_1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 6;
        int[][] paths = {
                {1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}
        };
        int[] gates = {1,3};
        int[] summits = {5};
        int[] answer = s.solution(n, paths, gates, summits);
        System.out.println(answer[0] + " "  + answer[1]);
    }

    static class Solution {
        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            int[] answer = new int[2];
            answer[1] = 10000001;

            int[][] mins = new int[n+1][n+1];
            for(int i=0; i<paths.length; i++) {
                mins[paths[i][0]][paths[i][1]] = paths[i][2];
                mins[paths[i][1]][paths[i][0]] = paths[i][2];
            }

            for(int i=0; i<gates.length; i++) {
                int start = gates[i];

                for(int j=0; j<summits.length; j++) {
                    boolean[] visited = new boolean[n+1];
                    int[] intensity = new int[n+1];
                    Arrays.fill(intensity, -2);
                    intensity[start] = 0;
                    visited[start] = true;
                    int end = summits[j];

                    // 방문하면 안되는 곳들 설정하기
                    for(int k=0; k<gates.length; k++) {
                        if(k != i) {
                            visited[gates[k]] = true;
                            intensity[gates[k]] = -1;
                        }
                    }
                    for(int k=0; k<summits.length; k++) {
                        if(k != j) {
                            visited[intensity[k]] = true;
                            intensity[intensity[k]] = -1;
                        }
                    }

                    // intensity 생성하기
                    int cur = start;
                    int next = 0;
                    int min = 0;
                    while(cur != end) {
                        // 최소값 찾기
                        for(int k=1; k<=n; k++) {
                            if(mins[cur][k] != 0 && intensity[k] != -1 && visited[k] == false) {
                                if(next == 0) next = k;
                                if(intensity[k] == -2 || intensity[k] > Math.max(mins[cur][k], intensity[cur])) {
                                    intensity[k] = Math.max(mins[cur][k], intensity[cur]);

                                    if(min == 0 || min >= intensity[k]) {
                                        min = intensity[k];
                                        next = k;
                                    }
                                }
                            }
                        }

                        // 다음값 설정
                        visited[next] = true;
                        cur = next;
                        next = 0;
                    }

                    // 결과값 확인
                    if(answer[1] >= intensity[j]) {
                        answer[0] = summits[j];
                        answer[1] = intensity[j];
                    }
                }
            }

            return answer;
        }
    }

}
