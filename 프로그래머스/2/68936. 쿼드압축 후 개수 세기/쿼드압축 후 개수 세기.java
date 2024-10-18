import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        // arr의 길이가 1인 경우
        if(arr.length == 1) {
            if(arr[0][0] == 0) return new int[]{1,0};
            else return new int[]{0,1};
        }
        
        int[] answer = new int[]{0,0}; // {0의 개수, 1의 개수}
        int len = arr.length;
        int idx = 0;
        int[][][] arrs = new int[10][][];
        arrs[idx++] = arr;
        
        // 압축하기
        while(len >= 4) {
            arrs[idx] = new int[len/2][len/2];
            for(int i=1; i<len; i+=2) {
                for(int j=1; j<len; j+=2) {
                    if(eqauls(arrs[idx-1], i, j)) arrs[idx][i/2][j/2] = arrs[idx-1][i][j];
                    else arrs[idx][i/2][j/2] = -1;
                }
            }

            len/=2;
            idx++;
        }
        
        // 개수 세기
        idx--;

        // 모든 숫자가 같은 경우
        if(arrs[idx][1][1]!=-1 && eqauls(arrs[idx], 1, 1)) {
            answer[arrs[idx][1][1]]++;
            return answer;
        }
        
        // 그 외의 경우
        int[] dx = {-1,-1,0,0};
        int[] dy = {-1,0,-1,0};
        Queue<int[]> q = new ArrayDeque<>(); //{idx, y, x}
        q.add(new int[]{idx, 1, 1});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int nIdx = cur[0];
            int y = cur[1];
            int x = cur[2];

            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(arrs[nIdx][ny][nx] == -1) q.add(new int[]{nIdx-1, ny*2+1, nx*2+1});
                else answer[arrs[nIdx][ny][nx]]++;
            }
        }
        
        return answer;
    }
    
    public boolean eqauls(int[][] arr, int y, int x) {
        if(arr[y][x] == arr[y][x-1] && arr[y-1][x] == arr[y-1][x-1] && arr[y][x-1] == arr[y-1][x-1]) return true;
        return false;
    }
}