import java.util.*;

class Solution {
    public String solution(String s) {
        if (s == null || s.isEmpty()) return "";
        
        StringBuilder sb = new StringBuilder();
        Set<Character> uniqueSet = new HashSet<>(); // 고유 문자 추적
        Set<Character> duplicateSet = new HashSet<>(); // 중복 문자 저장
        
        char firstChar = s.charAt(0);
        sb.append(firstChar);
        uniqueSet.add(firstChar);
        
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (uniqueSet.contains(c) || duplicateSet.contains(c)) {
                duplicateSet.add(c); // 중복 문자 등록
            } else {
                sb.append(c);
                uniqueSet.add(c); // 신규 문자 등록
            }
        }
        
        // 중복 문자 필터링
        StringBuilder filtered = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            if (!duplicateSet.contains(c)) {
                filtered.append(c);
            }
        }
        
        // 문자 정렬
        char[] chars = filtered.toString().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
