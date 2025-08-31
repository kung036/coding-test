class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] arr = new int[n][n];
        String[] answer = new String[n];
        
        de(arr1, arr, n);
        de(arr2, arr, n);
        
        for(int i=0; i<n; i++) {
            answer[i] = "";
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 0) answer[i] += " ";
                else answer[i] += "#";
            }
        }

        return answer;
    }
    
    public void de(int[] arr1, int[][] arr, int n) {
        for(int i=0; i<n; i++) {
            String b = Integer.toString(arr1[i], 2);
            int idx = b.length()-1;
            int tmp = n-1;
            while(idx >= 0) {
                if(b.charAt(idx--) == '1') arr[i][tmp]++;
                tmp--;
            }
        }
    }
}