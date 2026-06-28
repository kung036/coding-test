import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> score = new HashMap<>();
        for (char c : new char[]{'R','T','C','F','J','M','A','N'}) {
            score.put(c, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0); // 비동의 유형
            char agree    = survey[i].charAt(1); // 동의 유형
            int choice = choices[i];

            if (choice < 4) {
                score.put(disagree, score.get(disagree) + (4 - choice));
            } else if (choice > 4) {
                score.put(agree, score.get(agree) + (choice - 4));
            }
        }

        String[] indicators = {"RT", "CF", "JM", "AN"};
        StringBuilder result = new StringBuilder();

        for (String indicator : indicators) {
            char a = indicator.charAt(0);
            char b = indicator.charAt(1);
            // 점수가 같거나 a가 높으면 a, b가 높으면 b
            result.append(score.get(a) >= score.get(b) ? a : b);
        }

        return result.toString();
    }
}