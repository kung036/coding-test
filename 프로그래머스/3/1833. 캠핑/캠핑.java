import java.util.*;

class Solution {
    int[][] sum;

    // 압축 좌표 [x1..x2] x [y1..y2] 범위의 쐐기 수 (양 끝 포함)
    int count(int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) return 0;
        return sum[x2 + 1][y2 + 1] - sum[x1][y2 + 1] - sum[x2 + 1][y1] + sum[x1][y1];
    }

    public int solution(int n, int[][] data) {
        // 좌표 압축
        int[] xs = compress(data, 0);
        int[] ys = compress(data, 1);
        int[] cx = new int[n], cy = new int[n];
        for (int i = 0; i < n; i++) {
            cx[i] = Arrays.binarySearch(xs, data[i][0]);
            cy[i] = Arrays.binarySearch(ys, data[i][1]);
        }

        // 2차원 누적합
        int W = xs.length, H = ys.length;
        sum = new int[W + 1][H + 1];
        for (int i = 0; i < n; i++) sum[cx[i] + 1][cy[i] + 1]++;
        for (int i = 1; i <= W; i++)
            for (int j = 1; j <= H; j++)
                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (cx[i] == cx[j] || cy[i] == cy[j]) continue;   // 넓이 0
                int x1 = Math.min(cx[i], cx[j]), x2 = Math.max(cx[i], cx[j]);
                int y1 = Math.min(cy[i], cy[j]), y2 = Math.max(cy[i], cy[j]);
                // 경계를 제외한 내부에 쐐기가 없어야 함
                if (count(x1 + 1, y1 + 1, x2 - 1, y2 - 1) == 0) answer++;
            }
        }
        return answer;
    }

    int[] compress(int[][] data, int k) {
        int[] v = new int[data.length];
        for (int i = 0; i < data.length; i++) v[i] = data[i][k];
        return Arrays.stream(v).sorted().distinct().toArray();
    }
}