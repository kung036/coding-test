class Solution {
    public int solution(int n, int w, int num) {
        int floor = (num - 1) / w;
        int posInFloor = (num - 1) % w;
        int column = (floor % 2 == 0) ? posInFloor : (w - 1 - posInFloor);

        int maxFloor = (n - 1) / w;
        int total = 1;

        for (int f = floor + 1; f <= maxFloor; f++) {
            int startNum = f * w + 1;
            int endNum = Math.min((f + 1) * w, n);
            int count = endNum - startNum + 1;
            if (count <= 0) continue;

            boolean present;
            if (f % 2 == 0) {
                present = column < count;
            } else {
                present = column >= w - count;
            }

            if (present) total++;
        }

        return total;
    }
}