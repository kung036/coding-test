class Solution {
    int[] answer = new int[]{0, 0};

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }

    // (row, col)을 시작점으로 size x size 영역을 재귀 처리
    private void compress(int[][] arr, int row, int col, int size) {
        if (isUniform(arr, row, col, size)) {
            answer[arr[row][col]]++;
            return;
        }

        int half = size / 2;
        compress(arr, row,        col,        half); // 좌상
        compress(arr, row,        col + half, half); // 우상
        compress(arr, row + half, col,        half); // 좌하
        compress(arr, row + half, col + half, half); // 우하
    }

    // 해당 영역이 모두 같은 값인지 확인
    private boolean isUniform(int[][] arr, int row, int col, int size) {
        int val = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != val) return false;
            }
        }
        return true;
    }
}