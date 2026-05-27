import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char c : X.toCharArray()) countX[c - '0']++;
        for (char c : Y.toCharArray()) countY[c - '0']++;

        StringBuilder sb = new StringBuilder();

        for (int digit = 9; digit >= 1; digit--) {
            int common = Math.min(countX[digit], countY[digit]);
            sb.append(String.valueOf(digit).repeat(common));
        }

        int zeroCommon = Math.min(countX[0], countY[0]);
        if (sb.length() == 0) {
            return zeroCommon > 0 ? "0" : "-1";
        }

        sb.append("0".repeat(zeroCommon));
        return sb.toString();
    }
}