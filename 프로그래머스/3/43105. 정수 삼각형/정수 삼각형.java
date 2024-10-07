class Solution {
    public int solution(int[][] triangle) {
        // i행j열 -> Max((i-1)행(j-1)행, (i-1)행j행)
        
        int answer = 0;
        
        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                // 첫번째 열일때
                if(j == 0) triangle[i][j] += triangle[i-1][j];
                // 마지막 열일때
                else if(j == triangle[i].length-1) triangle[i][j] += triangle[i-1][j-1];
                else triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                
                if(triangle[i][j] > answer) answer = triangle[i][j];
            }
        }
        
        return answer;
    }
}