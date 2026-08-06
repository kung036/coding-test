class Solution {
    public int[] solution(String[] wallpaper) {
        int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;

        for (int r = 0; r < wallpaper.length; r++) {
            String row = wallpaper[r];
            for (int c = 0; c < row.length(); c++) {
                if (row.charAt(c) == '#') {
                    minR = Math.min(minR, r);
                    minC = Math.min(minC, c);
                    maxR = Math.max(maxR, r);
                    maxC = Math.max(maxC, c);
                }
            }
        }

        return new int[]{minR, minC, maxR + 1, maxC + 1};
    }
}