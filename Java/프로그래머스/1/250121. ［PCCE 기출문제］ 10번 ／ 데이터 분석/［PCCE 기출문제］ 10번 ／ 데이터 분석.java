import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> idx = Map.of(
            "code", 0, "date", 1, "maximum", 2, "remain", 3
        );

        int filterIdx = idx.get(ext);
        int sortIdx = idx.get(sort_by);

        return Arrays.stream(data)
            .filter(row -> row[filterIdx] < val_ext)
            .sorted(Comparator.comparingInt(row -> row[sortIdx]))
            .toArray(int[][]::new);
    }
}