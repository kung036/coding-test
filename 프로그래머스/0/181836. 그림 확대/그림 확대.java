class Solution {
    public String[] solution(String[] picture, int k) {
        int n = picture.length; // 세로 길이
        int m = picture[0].length(); // 가로 길이
        String[] answer = new String[n*k];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                String s = picture[j].charAt(i) + "";
                s = s.repeat(k);
                
                for(int x=0; x<k; x++) {
                    if(answer[j*k+x] == null) answer[j*k+x] = s;
                    else answer[j*k+x] += s;
                }
            }
        }
        
        return answer;
    }
}