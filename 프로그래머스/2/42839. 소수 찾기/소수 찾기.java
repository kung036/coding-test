import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        // 모든 경우의 수 찾기
        visited = new boolean[numbers.length()];
        char[] ch = numbers.toCharArray();
        dfs("", ch);
        
        // 최대값까지 소수 구하기
//         int max = set.stream().mapToInt(Integer::intValue).max().getAsInt();
//         int[] sosu = new int[max+1];
//         sosu[0] = -1;
//         sosu[1] = -1;
//         if(max >= 2) sosu[2] = 2;
//         for(int i=3; i<=max; i++) {
//             if(i%2 == 0) continue;
            
//             boolean check = true;
//             for(int j=3; j<i/2; j++) {
//                 if(i%j == 0) {
//                     check = false;
//                     break;
//                 }
//             }
//             if(check) sosu[i] = i;
//         }
        // System.out.println(set);
        // System.out.println(Arrays.toString(sosu));
        
        // 소수인지 확인하기
        int answer = 0;
        for(int s : set) {
            if(s == 2) {
                answer++;
                continue;
            } else if(s%2 == 0 || s == 0 || s == 1) continue;
            
            boolean check = true;
            for(int i=3; i<=s/2; i++) {
                if(s%i == 0) {
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        
        return answer;
    }
    
    public void dfs(String s, char[] ch) {
        if(s.length() == ch.length) return;
        
        for(int i=0; i<ch.length; i++) {
            if(visited[i]) continue;
            set.add(Integer.valueOf(s+ch[i]));
            visited[i] = true;
            dfs(s+ch[i], ch);
            visited[i] = false;
        }
    }
}