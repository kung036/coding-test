class Solution {
    public int solution(int n) {
        int count = 0;  // 3x 마을에서 카운트한 순서
        int num = 0;    // 10진수 숫자

        while (count < n) {
            num++;
            if (num % 3 == 0 || String.valueOf(num).contains("3")) {
                continue;
            }
            count++;
        }

        return num;
    }
}