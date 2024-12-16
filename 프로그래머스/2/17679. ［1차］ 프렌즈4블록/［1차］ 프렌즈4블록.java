import java.util.*;

class Solution {
    char[][] arr;
    
    public int solution(int m, int n, String[] board) {        
        // board 구하기
        Queue<int[]> q = new ArrayDeque<>();
        arr = new char[m][n];
        for(int i=0; i<m; i++) arr[i] = board[i].toCharArray();
        
        while(true) {
            // 2x2 블럭의 오른쪽 하단 좌표 q에 넣기
            for(int i=1; i<m; i++) {
                for(int j=1; j<n; j++) {
                    // 2x2 블럭이 된 경우
                    if(check(i, j)) q.add(new int[]{i, j});
                }
            }
            
            // q가 비어있으면 while문 나가기
            if(q.isEmpty()) break;
            
            // q 좌표를 제거하기
            while(!q.isEmpty()) {
                int[] xy = q.poll();
                int y = xy[0];
                int x = xy[1];
                
                arr[y][x] = '0';
                arr[y-1][x] = '0';
                arr[y][x-1] = '0';
                arr[y-1][x-1] = '0';
            }
            
            // 열 단위로 좌표 땡기기
            for(int i=0; i<n; i++) {
                for(int j=m-1; j>=1; j--) {
                    if(arr[j][i] == '0') {
                        int tmp = j-1;
                        while(0<=tmp && arr[j][i]=='0') {
                            if(arr[tmp][i] != '0') {
                                arr[j][i] = arr[tmp][i];
                                arr[tmp][i] = '0';
                            }
                            tmp--;
                        }
                    }
                }
            }
        }
        
        // 개수 세기
        int answer = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == '0') answer++;
            }
        }
        
        return answer;
    }
    
    public boolean check(int y, int x) {
        // 빈 값이 있을 경우
        if(arr[y][x]=='0' || arr[y-1][x]=='0' || arr[y][x-1]=='0' || arr[y-1][x-1]=='0')
            return false;
        if(arr[y][x]==arr[y-1][x] && arr[y][x]==arr[y][x-1] && arr[y][x]==arr[y-1][x-1])
            return true;
        return false;
    }
}