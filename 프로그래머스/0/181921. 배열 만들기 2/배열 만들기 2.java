import java.util.stream.IntStream;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = IntStream.rangeClosed(l, r)
                        .filter(i -> {
                            String s = String.valueOf(i);
                            s = s.replace("0", "");
                            s = s.replace("5", "");
                            return s.isEmpty() ? true : false;
                        })
                        .toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
    }
}