class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 1. goal에 있는 단어를 하나씩 꺼냄
        // 2. cards1[index1]과 cards2[index2] 단어 중 하나인지 확인
        //      2-1. 단어가 있는 배열의 인덱스 증가
        //      2-2. 단어가 없으면 No 반환
        // 3. for문이 정상적으로 종료되면 Yes 반환
        
        int index1 = 0;
        int index2 = 0;
        for(String word : goal) {
            if(index1 < cards1.length && word.equals(cards1[index1])) index1++;
            else if(index2 < cards2.length && word.equals(cards2[index2])) index2++;
            else return "No";
        }
        
        return "Yes";
    }
}