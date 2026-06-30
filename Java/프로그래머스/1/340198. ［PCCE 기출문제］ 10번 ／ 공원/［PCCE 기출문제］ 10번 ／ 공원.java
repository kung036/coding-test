import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;

        // mats를 큰 순서로 정렬해서 큰 돗자리부터 시도
        Integer[] sortedMats = Arrays.stream(mats).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedMats, Collections.reverseOrder());

        for (int size : sortedMats) {
            if (canPlace(park, rows, cols, size)) {
                return size;
            }
        }

        return -1;
    }

    private boolean canPlace(String[][] park, int rows, int cols, int size) {
        for (int i = 0; i + size <= rows; i++) {
            for (int j = 0; j + size <= cols; j++) {
                if (isEmptyArea(park, i, j, size)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEmptyArea(String[][] park, int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}