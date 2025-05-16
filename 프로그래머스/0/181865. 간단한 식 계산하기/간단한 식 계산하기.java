class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] strs = binomial.split(" ");
        int a = Integer.valueOf(strs[0]);
        int b = Integer.valueOf(strs[2]);
        switch(strs[1]) {
            case "+" : answer = a + b; break;
            case "-" : answer = a - b; break;
            case "*" : answer = a * b; break;
        }
        
        return answer;
    }
}