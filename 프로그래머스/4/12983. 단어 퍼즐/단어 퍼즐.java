import java.util.*;

class Solution {
    int INF = 20_001;
    
    public int solution(String[] strs, String t) {
        int answer = -1;
        int n = t.length();
        
        List<String> strsArr = Arrays.asList(strs);
        int[] dp = new int[n+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        // strs 단어 조각의 길이
        Set<Integer> sizes = new HashSet<>();
        for(String str : strsArr) {
            sizes.add(str.length());
        }
        
        for(int i=1; i<=n; i++) {
            for(int size : sizes) {
                if(i-size >= 0) {
                    String sub = t.substring(i-size, i);
                    if(strsArr.contains(sub))
                        dp[i] = Math.min(dp[i], dp[i-size]+1);
                }
            }
        }
        
        answer = dp[n] < INF ? dp[n] : -1;
        
        return answer;
    }
}