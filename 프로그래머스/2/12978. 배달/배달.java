import java.util.*;

class Node {
    int n; // 연결된 섬
    int w; // weight
     
    Node(int n, int w) {
        this.n = n;
        this.w = w;
    }
}

class Solution {
    public int solution(int N, int[][] roads, int K) {
        // 다익스트라 알고리즘        
        int[] dist = new int[N+1]; // 1번 노드로부터 거리
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        // 인접 리스트 구현
        List<Node>[] node = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            node[i] = new ArrayList<>();
        }
        for(int[] road : roads) {
            node[road[0]].add(new Node(road[1], road[2]));
            node[road[1]].add(new Node(road[0], road[2]));
        }
        
        // dfs - 가장 작은 거리 선택함
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
        queue.add(new Node(1, 0));
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            for(Node next : node[now.n]) {
                if(dist[next.n] > now.w + next.w) {
                    dist[next.n] = now.w + next.w;
                    queue.add(new Node(next.n, dist[next.n]));
                }
            }
        }
        
        // k보다 길이가 작은 마을 구하기
        int answer = 0;
        for(int i=1; i<=N; i++) {
            if(dist[i] <= K) answer++;
        }

        return answer;
    }
}