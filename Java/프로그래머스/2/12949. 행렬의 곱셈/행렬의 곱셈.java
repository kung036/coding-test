class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 결과값은 arr1의 행과 열의 길이가 같음
        int n = arr1.length;
        int m = arr2[0].length;
        int[][] answer = new int[n][m];
        
        // 행렬곱셈 : 왼쪽 행렬의 행들과 오른쪽 행렬의 열들의 곱들의 함
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sum = 0;
                
                // 행렬 결과값 계산
                for(int k=0; k<arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        
        return answer;
    }
}