package backjoon;

import java.util.*;

public class No9432 {
    public static void main(String[] x) {
        Scanner s = new Scanner(System.in);
        int[] R = new int[1024], T = new int[10201], P = {100, -1, -100, 1};
        int j, k, l, m, n = s.nextInt();
        while (n-- > 0) {
            T[l = s.nextInt() * 100 + s.nextInt()] = T[l += P[R[0] = s.nextInt()]] = 1;
            k = s.nextInt();
            for (m = j = 0; ++j < 1 << k; ) {
                if ((j & (j - 1)) == 0) m = j;
                T[l += P[R[j] = (R[j - m] + (j < m * 3 / 2 ? 2 : m % 2)) % 4]] = 1;
            }
        }
        for (l = 10100; --l >= 0; ) if (T[l] + T[l + 100] + T[l + 1] + T[l + 101] > 3) n++;
        System.out.print(n + 1);
//        s.next
    }
}