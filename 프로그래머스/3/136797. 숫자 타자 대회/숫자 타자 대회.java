import java.util.*;

class Node {
    int num;
    int weight;

    Node(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }
}

class Solution {
    List<List<Node>> nums;
    int[][] dist = new int[10][10];

    public int solution(String numbers) {
        // 그래프 그리기
        nums = new ArrayList<>();
        nums_init();

        // 다익스트라: 모든 숫자에서 출발해 숫자 간 최소 비용을 구한다
        for (int i = 0; i < 10; i++) dijkstra(i);
        for (int i = 0; i < 10; i++) dist[i][i] = 1; // 제자리에서 다시 누르면 1

        // DP: dp[l][r] = 왼손 l, 오른손 r일 때 최소 가중치 합
        final int INF = Integer.MAX_VALUE / 2;
        int[][] dp = new int[10][10];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[4][6] = 0;

        for (int k = 0; k < numbers.length(); k++) {
            int num = numbers.charAt(k) - '0';
            int[][] next = new int[10][10];
            for (int[] row : next) Arrays.fill(row, INF);

            for (int l = 0; l < 10; l++) {
                for (int r = 0; r < 10; r++) {
                    if (dp[l][r] >= INF) continue;
                    if (r != num) next[num][r] = Math.min(next[num][r], dp[l][r] + dist[l][num]);
                    if (l != num) next[l][num] = Math.min(next[l][num], dp[l][r] + dist[r][num]);
                }
            }
            dp = next;
        }

        int answer = INF;
        for (int l = 0; l < 10; l++)
            for (int r = 0; r < 10; r++)
                answer = Math.min(answer, dp[l][r]);
        return answer;
    }

    // start에서 모든 숫자까지의 최소 비용을 dist[start][*]에 채운다
    public void dijkstra(int start) {
        int[] d = dist[start];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.weight > d[cur.num]) continue;
            for (Node nx : nums.get(cur.num)) {
                int nw = cur.weight + nx.weight;
                if (nw < d[nx.num]) {
                    d[nx.num] = nw;
                    pq.add(new Node(nx.num, nw));
                }
            }
        }
    }

    public void nums_init() {
        for(int i=0; i<10; i++) {
            nums.add(new ArrayList<>());
        }

        // 0
        nums.get(0).add(new Node(8, 2));
        nums.get(0).add(new Node(7, 3));
        nums.get(0).add(new Node(9, 3));
        // 1
        nums.get(1).add(new Node(2, 2));
        nums.get(1).add(new Node(4, 2));
        nums.get(1).add(new Node(5, 3));
        // 2
        nums.get(2).add(new Node(1, 2));
        nums.get(2).add(new Node(3, 2));
        nums.get(2).add(new Node(5, 2));
        nums.get(2).add(new Node(4, 3));
        nums.get(2).add(new Node(6, 3));
        // 3
        nums.get(3).add(new Node(2, 2));
        nums.get(3).add(new Node(6, 2));
        nums.get(3).add(new Node(5, 3));
        // 4
        nums.get(4).add(new Node(1, 2));
        nums.get(4).add(new Node(5, 2));
        nums.get(4).add(new Node(7, 2));
        nums.get(4).add(new Node(2, 3));
        nums.get(4).add(new Node(8, 3));
        // 5
        nums.get(5).add(new Node(2, 2));
        nums.get(5).add(new Node(4, 2));
        nums.get(5).add(new Node(6, 2));
        nums.get(5).add(new Node(8, 2));
        nums.get(5).add(new Node(1, 3));
        nums.get(5).add(new Node(3, 3));
        nums.get(5).add(new Node(7, 3));
        nums.get(5).add(new Node(9, 3));
        // 6
        nums.get(6).add(new Node(3, 2));
        nums.get(6).add(new Node(5, 2));
        nums.get(6).add(new Node(9, 2));
        nums.get(6).add(new Node(2, 3));
        nums.get(6).add(new Node(8, 3));
        // 7
        nums.get(7).add(new Node(4, 2));
        nums.get(7).add(new Node(8, 2));
        nums.get(7).add(new Node(5, 3));
        nums.get(7).add(new Node(0, 3));
        // 8
        nums.get(8).add(new Node(5, 2));
        nums.get(8).add(new Node(7, 2));
        nums.get(8).add(new Node(9, 2));
        nums.get(8).add(new Node(0, 2));
        nums.get(8).add(new Node(4, 3));
        nums.get(8).add(new Node(6, 3));
        // 9
        nums.get(9).add(new Node(6, 2));
        nums.get(9).add(new Node(8, 2));
        nums.get(9).add(new Node(5, 3));
        nums.get(9).add(new Node(0, 3));
    }
}