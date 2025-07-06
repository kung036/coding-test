class Solution {
    public int solution(String s) {
        int answer = 0;
        int before = 0;
        String[] arr = s.split(" ");
        
        for(String str : arr) {
            if(str.equals("Z")) {
                answer -= before;
            } else {
                before = Integer.valueOf(str);
                answer += before;
            }
        }
        
        return answer;
    }
}