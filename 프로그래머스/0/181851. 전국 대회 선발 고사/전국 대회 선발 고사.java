class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int n = rank.length;
        int[] selected = new int[3];
        int count = 0;
        
        for (int i = 1; i <= n; i++) { // 등수는 1부터 n까지
            for (int j = 0; j < n; j++) {
                if (rank[j] == i && attendance[j]) {
                    selected[count++] = j;
                    if (count == 3) break;
                }
            }
            if (count == 3) break;
        }
        
        return 10000 * selected[0] + 100 * selected[1] + selected[2];
    }
}
