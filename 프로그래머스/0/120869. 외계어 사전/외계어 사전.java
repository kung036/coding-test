import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        // spell을 정렬해서 기준 문자열 생성
        char[] spellChars = new char[spell.length];
        for (int i = 0; i < spell.length; i++) {
            spellChars[i] = spell[i].charAt(0);
        }
        Arrays.sort(spellChars);
        String target = new String(spellChars);

        for (String word : dic) {
            // 길이가 다르면 패스
            if (word.length() != spell.length) continue;

            // word 문자 배열 정렬
            char[] wordChars = word.toCharArray();
            Arrays.sort(wordChars);

            if (target.equals(new String(wordChars))) {
                return 1;
            }
        }
        return 2; 
    }
}
