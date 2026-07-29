import java.util.*;

class Solution {
    private final char[] people = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private int count = 0;
    private String[] data;

    public int solution(int n, String[] data) {
        this.data = data;
        boolean[] used = new boolean[8];
        char[] order = new char[8];
        permute(order, used, 0);
        return count;
    }

    private void permute(char[] order, boolean[] used, int idx) {
        if (idx == 8) {
            if (checkAll(order)) count++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!used[i]) {
                used[i] = true;
                order[idx] = people[i];
                permute(order, used, idx + 1);
                used[i] = false;
            }
        }
    }

    private boolean checkAll(char[] order) {
        Map<Character, Integer> pos = new HashMap<>();
        for (int i = 0; i < 8; i++) pos.put(order[i], i);

        for (String cond : data) {
            char a = cond.charAt(0);
            char b = cond.charAt(2);
            char op = cond.charAt(3);
            int x = cond.charAt(4) - '0';

            int gap = Math.abs(pos.get(a) - pos.get(b)) - 1;

            boolean ok;
            switch (op) {
                case '=': ok = gap == x; break;
                case '<': ok = gap < x; break;
                case '>': ok = gap > x; break;
                default: ok = false;
            }
            if (!ok) return false;
        }
        return true;
    }
}