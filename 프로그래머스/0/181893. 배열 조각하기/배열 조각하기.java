import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        for(int i=0; i<query.length; i++) {
            if(i%2 == 0) { // 짝수일 경우 : 뒷부분 자르기
                arr = Arrays.copyOfRange(arr, 0, query[i]+1);
            } else { // 홀수일 경우 : 앞부분 자르기
                arr = Arrays.copyOfRange(arr, query[i], arr.length);
            }
            // System.out.println(Arrays.toString(arr));
        }
        
        return arr;
    }
}