class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int cnt = 0;
        int start = 1;

        for(int i=n-1; i>0; i-=2) {            
            for(int j=0; j<i; j++) {
                answer[cnt][cnt+j] = start+j;
                answer[cnt+j][n-cnt-1] = start+i+j;
                answer[n-cnt-1][n-1-j-cnt] = start+2*i+j;
                answer[n-1-j-cnt][cnt] = start+3*i+j;
            }
                             
            cnt++;
            start += 4*i;
        }
                
        if(n%2 == 1) answer[n/2][n/2] = n*n;

        return answer;
    }
}

// [[ 1, 2, 3, 4, 5, 6, 7],[24,25,26,27,28,29, 8],[23,40,41,42,43,30, 9],[22,39,48,49,44,31,10],[21,38,47,46,45,32,11],[20,37,36,35,34,33,12],[19,18,17,16,15,14,13]]