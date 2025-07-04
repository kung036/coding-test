import java.util.Arrays;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0], b = slicer[1], c = slicer[2];

        if (n == 1) return Arrays.copyOfRange(num_list, 0, b + 1);
        if (n == 2) return Arrays.copyOfRange(num_list, a, num_list.length);
        if (n == 3) return Arrays.copyOfRange(num_list, a, b + 1);
        
        int[] answer = {};
        if (n == 4) {
            int size = ((b - a) / c) + 1;
            answer = new int[size];
            int idx = 0;
            for (int i = a; i <= b; i += c)
                answer[idx++] = num_list[i];
        }
        return answer;
    }
}
