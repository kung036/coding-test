class Solution {
    public int solution(int storey) {
        int clicks = 0;

        while (storey != 0) {
            int lastDigit = storey % 10;
            int remaining = storey / 10;

            if (lastDigit > 5 || (lastDigit == 5 && (remaining % 10) >= 5)) {
                // 올림
                clicks += (10 - lastDigit);
                storey = remaining + 1;
            } else {
                // 내림
                clicks += lastDigit;
                storey = remaining;
            }
        }

        return clicks;
    }
}