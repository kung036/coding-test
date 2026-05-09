class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for (String s : babbling) {
            int i = 0;
            String prev = "";

            while (i < s.length()) {
                boolean matched = false;

                for (String word : words) {
                    if (!word.equals(prev) && s.startsWith(word, i)) {
                        i += word.length();
                        prev = word;
                        matched = true;
                        break;
                    }
                }

                if (!matched) break;
            }

            if (i == s.length()) answer++;
        }

        return answer;
    }
}