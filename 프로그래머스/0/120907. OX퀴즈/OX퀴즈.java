class Solution {
    public String[] solution(String[] quiz) {
        int n = quiz.length;
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {
            String[] str = quiz[i].split(" ");
            int x = Integer.valueOf(str[0]);
            int y = Integer.valueOf(str[2]);
            int z = Integer.valueOf(str[4]);
            if(str[1].equals("-")) y *= -1;
            if(z == x+y) answer[i] = "O";
            else answer[i] = "X";
        }
        
        return answer;
    }
}