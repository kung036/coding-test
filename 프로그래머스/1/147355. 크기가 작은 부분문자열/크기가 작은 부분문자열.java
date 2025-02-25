class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int n = p.length();
        long pi = Long.valueOf(p);

        for(int i=0; i<t.length()-n+1; i++) {
            String sub = t.substring(i, i+n);
            long ti = Long.valueOf(sub);
            if(ti <= pi) answer++;
        }
        
        return answer;
    }
}