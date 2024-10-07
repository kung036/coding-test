class Solution {
    int solution(int[][] land) {
        // land[i][j] 값 -> Max(land[i-1][j-1], land[i-1][j+1])
        
        int answer = 0;
        
        for(int i=1; i<land.length; i++) {
            for(int j=0; j<4; j++) {
                land[i][j] += max(land[i-1], j);
                
                if(land[i][j] > answer) answer = land[i][j];
            }
        }
        
        return answer;
    }
    
    public int max(int[] arr, int x) {
        int max = 0;

        for(int i=0; i<arr.length; i++) {
            if(i == x) continue;
            if(max < arr[i]) max = arr[i];
        }
        
        return max;
    }
}