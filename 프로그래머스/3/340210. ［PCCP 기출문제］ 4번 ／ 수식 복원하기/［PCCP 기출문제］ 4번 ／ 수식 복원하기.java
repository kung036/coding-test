import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        int n = expressions.length;
        String[] a = new String[n], op = new String[n], b = new String[n], c = new String[n];

        for (int i = 0; i < n; i++) {
            String[] t = expressions[i].split(" ");
            a[i] = t[0];
            op[i] = t[1];
            b[i] = t[2];
            c[i] = t[4];
        }

        // 가능한 진법 후보 (2 ~ 9진법)
        List<Integer> bases = new ArrayList<>();
        for (int base = 2; base <= 9; base++) {
            boolean ok = true;
            for (int i = 0; i < n && ok; i++) {
                // 모든 수식의 A, B는 해당 진법에서 쓸 수 있는 숫자여야 한다
                if (!digitsOk(a[i], base) || !digitsOk(b[i], base)) { ok = false; break; }

                // 결괏값이 있는 수식은 실제로 성립해야 한다
                if (!c[i].equals("X")) {
                    if (!digitsOk(c[i], base)) { ok = false; break; }
                    int x = Integer.parseInt(a[i], base);
                    int y = Integer.parseInt(b[i], base);
                    int z = Integer.parseInt(c[i], base);
                    int res = op[i].equals("+") ? x + y : x - y;
                    if (res != z) ok = false;
                }
            }
            if (ok) bases.add(base);
        }

        // 결괏값이 X인 수식 채우기
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!c[i].equals("X")) continue;

            String found = null;
            boolean same = true;
            for (int base : bases) {
                int x = Integer.parseInt(a[i], base);
                int y = Integer.parseInt(b[i], base);
                int res = op[i].equals("+") ? x + y : x - y;
                String s = Integer.toString(res, base);
                if (found == null) found = s;
                else if (!found.equals(s)) { same = false; break; }
            }
            answer.add(a[i] + " " + op[i] + " " + b[i] + " = " + (same ? found : "?"));
        }
        return answer.toArray(new String[0]);
    }

    private boolean digitsOk(String s, int base) {
        for (char ch : s.toCharArray()) {
            if (ch - '0' >= base) return false;
        }
        return true;
    }
}