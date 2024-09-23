import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int cnt = 0;
        
        for(int[] command : commands) {
            int i = command[0]-1;
            int j = command[1];
            int k = command[2]-1;
            
            // 배열을 자르고 정렬하기
            int[] subArr = new int[j-i];
            int index = 0;
            for(int s=i; s<j; s++) subArr[index++] = array[s];
            Arrays.sort(subArr);
            answer[cnt++] = subArr[k];
        }
        
        
        return answer;
    }
}