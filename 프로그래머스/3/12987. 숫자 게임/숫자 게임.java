import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // 두 점수 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int n = A.length;
        int idxA = 0;
        int idxB = 0;
        while(idxB < n) {
            if(A[idxA] < B[idxB]) answer++;
            else {
                while(idxB<n) {
                    if(A[idxA] < B[idxB]) {
                        answer++;
                        break;
                    }
                    idxB++;
                }
            }
            idxA++;
            idxB++;
        }
        
        return answer;
    }
}