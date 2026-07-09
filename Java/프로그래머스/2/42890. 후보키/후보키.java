import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int rows = relation.length;
        int cols = relation[0].length;
        int total = 1 << cols; // 2^cols 가지 속성 조합

        List<Integer> candidateKeys = new ArrayList<>();

        for (int mask = 1; mask < total; mask++) {
            // 최소성 체크: 기존 후보키의 부분집합이면 스킵
            if (isSubset(candidateKeys, mask)) continue;

            // 유일성 체크
            if (isUnique(relation, rows, cols, mask)) {
                candidateKeys.add(mask);
            }
        }

        return candidateKeys.size();
    }

    // 현재 mask가 기존 후보키 중 하나의 상위집합인지 확인 (최소성 위반)
    private boolean isSubset(List<Integer> candidateKeys, int mask) {
        for (int key : candidateKeys) {
            if ((mask & key) == key) return true; // key가 mask의 부분집합
        }
        return false;
    }

    // 해당 속성 조합(mask)으로 모든 튜플을 유일하게 식별 가능한지 확인
    private boolean isUnique(String[][] relation, int rows, int cols, int mask) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols; j++) {
                if ((mask & (1 << j)) != 0) {
                    sb.append(relation[i][j]).append(",");
                }
            }
            if (!set.add(sb.toString())) return false;
        }
        return true;
    }
}