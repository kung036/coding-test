import java.util.*;

class Solution {
    static Set<Integer> set;
    static boolean[] visited;
    static int max = 0;

    public int solution(String numbers) {
        set = new HashSet<>();
        visited = new boolean[numbers.length()];

        perm(numbers, "");

        boolean[] isPrime = sieve(max);

        int answer = 0;
        for (int num : set) {
            if (num >= 2 && isPrime[num]) answer++;
        }
        return answer;
    }

    private void perm(String numbers, String current) {
        if (!current.isEmpty()) {
            int value = Integer.parseInt(current);
            set.add(value);
            max = Math.max(max, value);
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;

            visited[i] = true;
            perm(numbers, current + numbers.charAt(i));
            visited[i] = false;
        }
    }

    private boolean[] sieve(int n) {
        if (n < 2) return new boolean[Math.max(n + 1, 2)];

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) continue;
            for (int j = i * i; j <= n; j += i) {
                prime[j] = false;
            }
        }
        return prime;
    }
}