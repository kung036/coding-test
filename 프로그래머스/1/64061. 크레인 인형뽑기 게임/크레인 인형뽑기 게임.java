import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 게임 화면 상태 : board
        // 크레인이 이동한 위치 : moves
        
        // board의 길이 만큼인 stack 배열 생성
        // board의 내용을 아래부터 stack에 집에 넣음

        // moves의 for문을 돌면서 moves의 index 위치의 stack을 pop해서 뽑은 인형의 stack에 넣음
        // 이때 넣을 인형과 마지막에 넣을 인형이 같다면 answer 증가 및 stack pop
        
        int answer = 0;
        int n = board.length;
        Stack<Integer> catchs = new Stack<>();
        Stack<Integer>[] stacks = new Stack[n+1];
        Arrays.fill(stacks, new Stack<>());
        for(int i=1; i<=n; i++) {
            stacks[i] = new Stack<>();
        }
        
        // board의 내용을 아래부터 stack에 집에 넣음
        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 0) continue;
                stacks[j+1].push(board[i][j]);
            }
        }
        
        for(int index : moves) {
            if(stacks[index].isEmpty()) continue; // stack이 비어있으면 다음 위치로 이동
            
            int doll = stacks[index].pop(); // 크레인이 뽑은 인형
            if(!catchs.isEmpty() && doll == catchs.peek()) {
                catchs.pop();
                answer += 2;
            } else catchs.push(doll);
        }
        
        return answer;
    }
}