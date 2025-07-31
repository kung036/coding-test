class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        if(max-min == 1) return 1;
        
        answer += max - (max-min+1) + 1;
        answer += (max+min-1) - (max+1) + 1;
        
        return answer;
    }
}