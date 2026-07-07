import java.util.*;

class Solution {
    static int[] discounts = {10, 20, 30, 40};
    static int m;
    static int bestSubscribe = 0;
    static int bestSales = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        m = emoticons.length;
        // 각 이모티콘에 할인율 조합을 완전탐색 (4^m 가지)
        dfs(0, new int[m], users, emoticons);
        return new int[]{bestSubscribe, bestSales};
    }

    private void dfs(int idx, int[] rates, int[][] users, int[] emoticons) {
        if (idx == m) {
            simulate(rates, users, emoticons);
            return;
        }
        for (int discount : discounts) {
            rates[idx] = discount;
            dfs(idx + 1, rates, users, emoticons);
        }
    }

    private void simulate(int[] rates, int[][] users, int[] emoticons) {
        int subscribe = 0;
        int sales = 0;

        for (int[] user : users) {
            int minRate = user[0]; // 최소 할인율 기준
            int limit   = user[1]; // 플러스 가입 기준 금액
            int total = 0;

            for (int j = 0; j < m; j++) {
                if (rates[j] >= minRate) {
                    total += emoticons[j] * (100 - rates[j]) / 100;
                }
            }

            if (total >= limit) {
                subscribe++;
            } else {
                sales += total;
            }
        }

        // 1순위: 가입자 수, 2순위: 판매액
        if (subscribe > bestSubscribe ||
           (subscribe == bestSubscribe && sales > bestSales)) {
            bestSubscribe = subscribe;
            bestSales = sales;
        }
    }
}