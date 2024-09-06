import java.util.*;

import java.util.*;
class Solution {
    public int solution(int n, int a, int b) {
        // 1 2 3 4 5 6 7 8 : 1
        // 1   4   5   7   : 2
        // 4       7       : 3
        
        // 무조건 왼쪽이 이긴다고 가정
        // 만약 A 또는 B 인덱스라면 A 또는 B를 올림
        // 만약 A B라면 라운드 반환
        
        int round = 0;
        for(; a!=b; round++) {
            a = (a+1) / 2;
            b = (b+1) / 2;
        }
        
        return round;
    }
}