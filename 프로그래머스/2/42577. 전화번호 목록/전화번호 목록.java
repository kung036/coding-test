import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = Arrays.stream(phone_book).collect(Collectors.toCollection(HashSet::new));
        
        // 각 문자열의 단위를 쪼개서 이미 존재하는지 확인
        for(String phone : phone_book) {
            for(int i=1; i<phone.length(); i++) {
                if(set.contains(phone.substring(0,i))) return false;
            }
        }
        
        return true;
    }
}