class Solution {
    public int[] solution(long n) {
        String[] str = String.valueOf(n).split("");
        int[] answer = new int[str.length];
        for(int i=str.length-1; i>=0; i--) {
            answer[str.length-1-i] = Integer.valueOf(str[i]);
        }
        return answer;
    }
}