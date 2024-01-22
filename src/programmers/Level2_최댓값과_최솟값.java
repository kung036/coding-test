package programmers;

import java.util.*;

class Level2_최댓값과_최솟값 {
    public String solution(String s) {
        String answer = "";

        int[] arr = Arrays.stream(s.split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        answer += Arrays.stream(arr).min().getAsInt()
                + " " + Arrays.stream(arr).max().getAsInt();

        return answer;
    }
}