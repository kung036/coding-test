import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;          // 숫자 개수
        int[] num = new int[n];
        char[] op = new char[n - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) num[i / 2] = Integer.parseInt(arr[i]);
            else op[i / 2] = arr[i].charAt(0);
        }

        int[][] max = new int[n][n];
        int[][] min = new int[n][n];
        for (int[] row : max) Arrays.fill(row, Integer.MIN_VALUE);
        for (int[] row : min) Arrays.fill(row, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) max[i][i] = min[i][i] = num[i];

        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                for (int k = i; k < j; k++) {    // op[k]: num[k]와 num[k+1] 사이
                    if (op[k] == '+') {
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k + 1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k + 1][j]);
                    } else {
                        max[i][j] = Math.max(max[i][j], max[i][k] - min[k + 1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] - max[k + 1][j]);
                    }
                }
            }
        }
        return max[0][n - 1];
    }
}