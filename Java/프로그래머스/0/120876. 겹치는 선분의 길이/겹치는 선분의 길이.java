class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int[] arr = new int[201];
        for(int[] l : lines) {
            for(int i=l[0]+100; i<l[1]+100; i++) {
                arr[i]++;
            }
        }
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > 1) answer++;
        }
        
        return answer;
    }
}