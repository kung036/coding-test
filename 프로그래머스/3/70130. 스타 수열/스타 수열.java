class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] cnt = new int[n];
        for (int v : a) cnt[v]++;

        int answer = 0;
        for (int x = 0; x < n; x++) {
            // x가 공통 원소가 되려면 최대 cnt[x]쌍 → 현재 답보다 못하면 스킵
            if (cnt[x] * 2 <= answer) continue;

            int pairs = 0;
            for (int i = 0; i < n - 1; i++) {
                // 둘 다 x가 아니면 공통 원소가 될 수 없음
                if (a[i] != x && a[i + 1] != x) continue;
                // 두 원소가 같으면 교집합은 있어도 (a[i] != a[i+1]) 조건 위반
                if (a[i] == a[i + 1]) continue;

                pairs++;
                i++; // 이미 쓴 원소는 건너뜀
            }
            answer = Math.max(answer, pairs * 2);
        }
        return answer;
    }
}