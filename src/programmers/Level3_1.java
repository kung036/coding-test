package programmers;
//
//import java.util.*;
//
//// 등산코스 정하기
//public class Level3_1 {
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int n = 6;
//        int[][] paths = {
//                {1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}
//        };
//        int[] gates = {1,3};
//        int[] summits = {5};
//        int[] answer = s.solution(n, paths, gates, summits);
//        System.out.println(answer[0] + " "  + answer[1]);
//    }
//
//    static class Solution {
//        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
//            int[] answer = new int[2];
//            answer[1] = 10000001;
//
//            int[][] mins = new int[n+1][n+1];
//            for(int i=0; i<paths.length; i++) {
//                mins[paths[i][0]][paths[i][1]] = paths[i][2];
//                mins[paths[i][1]][paths[i][0]] = paths[i][2];
//            }
//
//            for(int i=0; i<gates.length; i++) {
//                int start = gates[i];
//
//                for(int j=0; j<summits.length; j++) {
//                    boolean[] visited = new boolean[n+1];
//                    int[] intensity = new int[n+1];
//                    Arrays.fill(intensity, -2);
//                    intensity[start] = 0;
//                    visited[start] = true;
//                    int end = summits[j];
//
//                    // 방문하면 안되는 곳들 설정하기
//                    for(int k=0; k<gates.length; k++) {
//                        if(k != i) {
//                            visited[gates[k]] = true;
//                            intensity[gates[k]] = -1;
//                        }
//                    }
//                    for(int k=0; k<summits.length; k++) {
//                        if(k != j) {
//                            visited[intensity[k]] = true;
//                            intensity[intensity[k]] = -1;
//                        }
//                    }
//
//                    // intensity 생성하기
//                    int cur = start;
//                    int next = 0;
//                    int min = 0;
//                    while(cur != end) {
//                        // 최소값 찾기
//                        for(int k=1; k<=n; k++) {
//                            if(mins[cur][k] != 0 && intensity[k] != -1 && visited[k] == false) {
//                                if(next == 0) next = k;
//                                if(intensity[k] == -2 || intensity[k] > Math.max(mins[cur][k], intensity[cur])) {
//                                    intensity[k] = Math.max(mins[cur][k], intensity[cur]);
//
//                                    if(min == 0 || min >= intensity[k]) {
//                                        min = intensity[k];
//                                        next = k;
//                                    }
//                                }
//                            }
//                        }
//
//                        // 다음값 설정
//                        visited[next] = true;
//                        cur = next;
//                        next = 0;
//                    }
//
//                    // 결과값 확인
//                    if(answer[1] >= intensity[j]) {
//                        answer[0] = summits[j];
//                        answer[1] = intensity[j];
//                    }
//                }
//            }
//
//            return answer;
//        }
//    }
//
//}
// 참고 코드 리팩토링 : https://velog.io/@doforme/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9E%90%EB%B0%94-%EB%93%B1%EC%82%B0-%EC%BD%94%EC%8A%A4-%EC%A0%95%ED%95%98%EA%B8%B0
import java.util.*;

class Level3_1 {
    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<Node>> graph = createGraph(n, paths);
        Set<Integer> summitSet = createSet(summits);
        Set<Integer> gateSet = createSet(summits);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] intensities = new int[n + 1];
        Arrays.fill(intensities, Integer.MAX_VALUE);

        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
            intensities[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (gateSet.contains(now.index) || summitSet.contains(now.index)) {
                continue;
            }

            if (intensities[now.index] < now.intensity) {
                continue;
            }

            for (Node next : graph.get(now.index)) {
                int intensity = Math.max(next.intensity, now.intensity);
                if (intensities[next.index] > intensity) {
                    intensities[next.index] = intensity;
                    pq.offer(new Node(next.index, intensity));
                }
            }
        }

        int index = -1;
        int minIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);
        for (int summit : summits) {
            if (intensities[summit] < minIntensity) {
                minIntensity = intensities[summit];
                index = summit;
            }
        }
        return new int[]{index, minIntensity};
    }

    private static Set<Integer> createSet(int[] arr) {
        Set<Integer> getSet = new HashSet<>();

        for (int gate : arr) {
            getSet.add(gate);
        }
        return getSet;
    }

    private static List<List<Node>> createGraph(int n, int[][] paths) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : paths) {
            graph.get(p[0]).add(new Node(p[1], p[2]));
            graph.get(p[1]).add(new Node(p[0], p[2]));
        }

        return graph;
    }


    public static void main(String[] args) {
//        int n = 6;
//        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
//        int[] gates = {1, 3};
//        int[] summits = {5};

        int n = 7;
        int[][] paths = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
        int[] gates = {1};
        int[] summits = {2, 3, 4};

        for (int i : solution(n, paths, gates, summits)) {
            System.out.print(i + " ");
        }
    }
}

class Node implements Comparable<Node> {
    int index;
    int intensity;

    public Node(int index, int intensity) {
        this.index = index;
        this.intensity = intensity;
    }

    @Override
    public int compareTo(Node o) {
        return this.intensity - o.intensity;
    }
}
