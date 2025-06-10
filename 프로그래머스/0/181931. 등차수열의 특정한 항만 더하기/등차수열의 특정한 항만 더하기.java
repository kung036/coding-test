class Solution {
    public int solution(int a, int d, boolean[] included) {
        int[] arr = new int[included.length];
        int answer = 0;
        for(int i=0; i<included.length; i++) {
            if(included[i]) answer += a + d*i;
        }
        
        return answer;
    }
}