import java.util.Map;

class Solution {
    public int solution(int n, String control) {
        int answer = n;
        Map<Character, Integer> moveMap = Map.of('w', 1, 's', -1, 'd', 10, 'a', -10);

        for (char c : control.toCharArray()) {
            answer += moveMap.getOrDefault(c, 0);
        }

        return answer;
    }
}