class Solution {
    public int solution(int[] wallet, int[] bill) {
        int max = Math.max(wallet[0], wallet[1]);
        int min = Math.min(wallet[0], wallet[1]);
        int answer = 0;
        
        while(true) {
            if(Math.max(bill[0], bill[1]) <= max &&
                Math.min(bill[0], bill[1]) <= min) break;
            if(bill[0] > bill[1]) bill[0] /= 2;
            else bill[1] /= 2;
            answer++;
        }
        
        return answer;
    }
}