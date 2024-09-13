import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        // computers : 인접 행렬로 표현된 그래프
        // dfs를 통해서 network
        
        int answer = 0;
        Set<Integer> network = new HashSet<>(); // 네트워크로 연결된 컴퓨터
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i=0; i<n; i++) {
            if(network.contains(i)) continue; // 방문하지 않은 노드만 순회
            answer++;
            stack.add(i);
            
            while(!stack.isEmpty()) { // 연결된 네트워크 전부 순회
                int computer = stack.pop();
                network.add(computer);

                for(int j=0; j<computers[computer].length; j++) {
                    if(computer == j) continue;
                    
                    if(computers[computer][j] == 1 && !network.contains(j)) stack.push(j);
                }
            }
        }
        
        
        return answer;
    }
}