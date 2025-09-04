class Solution {
    public int[] solution(int num, int total) {
        int start = (total/num) - (num/2);
        if(total%num != 0) start++;
        // System.out.println(start);
        // System.out.println(total/num);
        // System.out.println((int)num/2);
        // System.out.println(total%num != 0);
        int[] answer = new int[num];
        int idx = 0;
        for(int i=start; i<start+num; i++) {
            answer[idx++] = i;
        }
        
        return answer;
    }
}