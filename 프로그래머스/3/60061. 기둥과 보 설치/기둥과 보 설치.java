import java.util.ArrayList;
import java.util.List;

class Solution {
    // 구조물을 나타내기 위한 배열 (x좌표, y좌표, 구조물 종류)
    private boolean[][][] structure;

    public int[][] solution(int n, int[][] build_frame) {
        structure = new boolean[n + 1][n + 1][2];  // 0: 기둥, 1: 보

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];
            int cmd = frame[3];

            if (cmd == 1) {  // 설치
                if (canBuild(x, y, type)) {
                    structure[x][y][type] = true;
                }
            } else {  // 제거
                structure[x][y][type] = false;
                if (!isValid()) {
                    structure[x][y][type] = true;  // 제거가 불가능한 경우 복구
                }
            }
        }

        // 결과 저장
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (structure[i][j][0]) result.add(new int[]{i, j, 0});
                if (structure[i][j][1]) result.add(new int[]{i, j, 1});
            }
        }

        // 결과 정렬 후 반환
        result.sort((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) return Integer.compare(a[2], b[2]);
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        return result.toArray(new int[result.size()][]);
    }

    // 특정 위치에 기둥 또는 보를 설치 가능한지 확인하는 함수
    private boolean canBuild(int x, int y, int type) {
        if (type == 0) {  // 기둥 설치 조건
            return y == 0 || structure[x][y - 1][0] || (x > 0 && structure[x - 1][y][1]) || structure[x][y][1];
        } else {  // 보 설치 조건
            return (y > 0 && structure[x][y - 1][0]) || (x < structure.length - 1 && y > 0 && structure[x + 1][y - 1][0]) ||
                    (x > 0 && structure[x - 1][y][1] && structure[x + 1][y][1]);
        }
    }

    // 모든 구조물이 조건을 만족하는지 확인하는 함수
    private boolean isValid() {
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[0].length; j++) {
                if (structure[i][j][0] && !canBuild(i, j, 0)) return false;
                if (structure[i][j][1] && !canBuild(i, j, 1)) return false;
            }
        }
        return true;
    }
}
