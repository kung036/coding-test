import java.util.*;

class Solution {    
    public int solution(int x, int y, int n) {
        // y = x + n
        // y = x * 2
        // y = x * 3
        if(x == y) return 0;
        
        // [cnt, current]
        Queue<int[]> q = new PriorityQueue<>((q1, q2) -> Integer.compare(q1[0], q2[0]));
        q.add(new int[]{0, y});
        int[] dp = new int[y+1];
        
        int answer = -1;
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            dp[poll[1]] = poll[0];
            
            if(poll[1] == x) {
                answer = poll[0];
                break;
            }
            
            int[] tmp = new int[3];
            Arrays.fill(tmp, -1);
            tmp[0] = poll[1]-n;
            if(poll[1]%2==0) tmp[1] = poll[1]/2;
            if(poll[1]%3==0) tmp[2] = poll[1]/3;
            
            for(int i=0; i<3; i++) {
                if(tmp[i] == -1) continue;
                if(x <= tmp[i]) q.add(new int[]{poll[0]+1, tmp[i]});
            }           
            
            // q.forEach(o -> System.out.print(Arrays.toString(o)));
            // System.out.println();

        }
        
        return answer;
    }    
}