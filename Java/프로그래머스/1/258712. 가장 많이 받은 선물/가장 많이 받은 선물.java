import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) idx.put(friends[i], i);

        int[][] give = new int[n][n];
        int[] giveTotal = new int[n];
        int[] receiveTotal = new int[n];

        for (String g : gifts) {
            String[] parts = g.split(" ");
            int a = idx.get(parts[0]);
            int b = idx.get(parts[1]);
            give[a][b]++;
            giveTotal[a]++;
            receiveTotal[b]++;
        }

        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) {
            giftIndex[i] = giveTotal[i] - receiveTotal[i];
        }

        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (give[i][j] > give[j][i]) {
                    next[i]++;
                } else if (give[i][j] < give[j][i]) {
                    next[j]++;
                } else {
                    if (giftIndex[i] > giftIndex[j]) next[i]++;
                    else if (giftIndex[i] < giftIndex[j]) next[j]++;
                }
            }
        }

        int answer = 0;
        for (int v : next) answer = Math.max(answer, v);
        return answer;
    }
}