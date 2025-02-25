class Solution {
    public boolean solution(String s) {
        int n = s.length();
        if(n != 4 && n != 6) return false;
        
        boolean answer = true;
        try {
            Integer.valueOf(s);
        } catch(Exception e) {
            answer = false;
        }
        
        return answer;
    }
}