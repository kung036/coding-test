class Solution {
    public int solution(int storey) {
        int clicks = 0;

        while (storey > 0) {
            int digit = storey % 10;
            int next  = storey / 10;

            if (digit > 5 || (digit == 5 && (next % 10) >= 5)) {
                clicks += 10 - digit;
                next++;
            } else {
                clicks += digit;
            }

            storey = next;
        }

        return clicks;
    }
}