class Solution {
    public int[] solution(int[] arr, int n) {
        int cnt = arr.length % 2 == 0 ? 1 : 0;
        for(int i=0; i<arr.length; i++) {
            if((cnt+i)%2 == 0) arr[i] += n;
        }
        return arr;
    }
}