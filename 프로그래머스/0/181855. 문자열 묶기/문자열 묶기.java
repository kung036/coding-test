import java.util.Arrays;

class Solution {
    public int solution(String[] strArr) {
        int[] count = new int[31]; // 1~30 인덱스 사용 (0번은 사용 안함)
        for (String s : strArr) {
            count[s.length()]++;
        }
        return Arrays.stream(count).max().getAsInt();
    }
}
