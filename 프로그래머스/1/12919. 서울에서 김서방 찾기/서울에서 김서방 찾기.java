class Solution {
    public String solution(String[] seoul) {
        int idx = 0;
        while(!seoul[idx].equals("Kim")) {
            idx++;
        }
        
        return "김서방은 " + idx + "에 있다";
    }
}