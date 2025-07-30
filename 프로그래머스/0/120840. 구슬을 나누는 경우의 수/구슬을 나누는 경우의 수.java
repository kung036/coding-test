class Solution {
    public int solution(int balls, int share) {
        if(balls == share) return 1;
        if(balls-share == 1) return balls;
        int max = Math.max(share, balls-share);
        int min = Math.min(share, balls-share);
        
        double up = 1;        
        for(int i=max+1; i<=balls; i++) {
            up *= i;
        }

        double down = 1;
        for(int i=1; i<=min; i++) {
            down *= i;
        }
        
        return (int) (up / down);
    }
}