class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        System.out.println(Integer.valueOf('a'));
        System.out.println(Integer.valueOf('A'));
        System.out.println(Integer.valueOf('z'));
        System.out.println(Integer.valueOf('Z'));
        for(char c : my_string.toCharArray()) {
            if(c <= 'Z') answer[Integer.valueOf(c - 'A')]++;
            else answer[Integer.valueOf(c - 'a' + 26)]++;
        }
        
        return answer;
    }
}