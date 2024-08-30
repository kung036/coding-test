import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmds) {
        // list 삭제 -> O(n)
        // n : 표의 행 개수
        // k : 처음 선택된 행의 위치
        
        // up 배열과 down 배열 구현 -> 다음 인덱스의 위치를 담은 배열
        // cmd 명령어 실행
        // 제거된 것들은 stack에 index 넣기
        // 삭제 방법에 대해서 유의할 것
        
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        Stack<Integer> stack = new Stack<>();
        
        // up, down 배열 구현
        for(int i=0; i<n+2; i++) {
            up[i] = i-1;
            down[i] = i+1;
        }
        
        int index = k+1; // 선택한 인덱스
        for(String cmd : cmds) {
            if(cmd.equals("C")) { // 삭제할 경우
                stack.push(index);
                up[down[index]] = up[index];
                down[up[index]] = down[index];
                
                // index 아래로 이동
                if(down[index] > n) index = up[index];
                else index = down[index];
            } else if(cmd.equals("Z")) { // 복구
                int recover = stack.pop();
                up[down[recover]] = recover;
                down[up[recover]] = recover;
            } else { // 다른 행 선택
                String[] moveCmd = cmd.split(" ");
                int x = Integer.valueOf(moveCmd[1]);
                
                for(int i=0; i<x; i++) {
                    if(moveCmd[0].equals("U")) index = up[index];
                    else index = down[index];
                }
            }
        }
        
        // answer 출력하기
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for(int i : stack) {
            answer[i-1] = 'X';
        }
        
        return new String(answer);
    }
}