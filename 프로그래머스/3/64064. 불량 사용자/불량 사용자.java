import java.util.*;

class Solution {
    Set<String> answer = new HashSet<>();
    List<Set<String>> answers = new ArrayList<>();
    Set<String>[] set;
    int cnt = 0;
    int n;
    
    public int solution(String[] user_id, String[] banned_id) {
        // ban되는 id 구하기        
        n = banned_id.length;
        set = new Set[n];
        for(int i=0; i<n; i++) {
            String ban = banned_id[i];
            set[i] = new HashSet<>();
            
            for(int j=0; j<user_id.length; j++) {
                if(compare(user_id[j], ban)) set[i].add(user_id[j]);
            }
            // System.out.println(set[i]);
        }

        // 모든 id 곱하기(조합O, 순서X)
        // System.out.println(set[0].equals(set[1]));
        dfs(0);
        return cnt;
    }
    
    // 밴당한 아이디인지 확인하기
    public boolean compare(String user, String ban) {
        // System.out.println(ban + " " + user);
        // 두 아이디의 길이가 다른 경우
        if(user.length() != ban.length()) return false;

        // 두 아이디 비교
        char[] cuser = user.toCharArray();
        char[] cban = ban.toCharArray();
        
        for(int i=0; i<cban.length; i++) {
            // System.out.println(cban[i] + " " + cuser[i]);
            if(cban[i] == '*') continue;
            if(cban[i] != cuser[i]) return false;
        }
        
        return true;
    }
    
    public void dfs(int dp) {
        if(dp == n) {
            // System.out.println("answer : " + answer);
            if(answer.size() == n) {
                for(int i=0; i<answers.size(); i++) {
                    // System.out.println("answers : " + answers.get(i));
                    // 이미 생성된 조합
                    if(answer.equals(answers.get(i))) return;
                }
                answers.add(new HashSet<>(answer));
                cnt++;
                // System.out.println(cnt);
            }
            return;
        }
        
        for(String cur : set[dp]) {
            if(!answer.contains(cur)) {
                answer.add(cur);
                dfs(dp+1);
                answer.remove(cur);
            }
        }
    }
}