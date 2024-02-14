package programmers;

// 정확성, 효율성 -> 전부 미통과

public class Level2_2xn_타일링 {
    int[] factorial_arr = new int[60001];

    public int solution(int n) {
        int answer = 0;

        // 세로(ㅣ)
        int a = n;

        // 가로(ㅡ)
        int b = 0;

        while(true) {
            // 조합 n C b
            answer += combination(a+b, b);

            if(a > 1) {
                a-=2;
                b++;
            } else break;
            // else if(n%2 == 0) {
            //     a-=2;
            //     b++;
            // }
        }

        return answer;
    }

    // 팩토리얼
    public int factorial(int n) {
        if(n == 1 || n == 0) return 1;
        return n * factorial(n-1);
    }

    public int fact(int n) {
        if(factorial_arr[n] == 0) factorial_arr[n] = factorial(n);
        return factorial_arr[n];
    }

    // 조합 n C r = n! / ((n-r)! * r!)
    public int combination(int n, int r) {
        int a, b, c;

        // n! -> a
        a = fact(n);

        // (n-1)! -> b
        b = fact(n-r);

        // r! -> c
        c = fact(r);

        // System.out.println("n : " + n + " r : " + r);
        // System.out.println("a : " + a + " b : " + b + " c : " + c);
        // System.out.println(a/(b*c));

        return a/(b*c);
    }
}