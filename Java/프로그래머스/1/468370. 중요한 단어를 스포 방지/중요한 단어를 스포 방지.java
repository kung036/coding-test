import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();

        // 단어 토큰화 (시작, 끝 인덱스 포함)
        List<int[]> wordPos = new ArrayList<>();
        List<String> wordText = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (message.charAt(i) == ' ') { i++; continue; }
            int start = i;
            while (i < n && message.charAt(i) != ' ') i++;
            int end = i - 1;
            wordPos.add(new int[]{start, end});
            wordText.add(message.substring(start, end + 1));
        }

        int wCount = wordPos.size();
        int rCount = spoiler_ranges.length;

        Set<String> safeWords = new HashSet<>(); // 스포 구간과 전혀 겹치지 않는 단어들
        List<List<Integer>> completesAt = new ArrayList<>();
        for (int r = 0; r < rCount; r++) completesAt.add(new ArrayList<>());

        int idx = 0; // 스포 구간 포인터 (역행하지 않음)
        for (int w = 0; w < wCount; w++) {
            int ws = wordPos.get(w)[0];
            int we = wordPos.get(w)[1];

            // 이 단어보다 완전히 앞서 끝난 구간은 영구히 건너뜀
            while (idx < rCount && spoiler_ranges[idx][1] < ws) idx++;

            int j = idx;
            int lastRange = -1;
            while (j < rCount && spoiler_ranges[j][0] <= we) {
                lastRange = j; // 이 단어를 덮는 가장 마지막(가장 나중에 열리는) 구간
                j++;
            }

            if (lastRange == -1) {
                safeWords.add(wordText.get(w)); // 스포 구간 밖에 있는 단어
            } else {
                completesAt.get(lastRange).add(w); // 이 구간이 열릴 때 완전히 공개됨
            }
        }

        Set<String> revealed = new HashSet<>(); // 이미 공개된 적 있는 스포 단어들
        int important = 0;

        for (int r = 0; r < rCount; r++) {
            for (int w : completesAt.get(r)) {
                String text = wordText.get(w);
                boolean notInSafeZone = !safeWords.contains(text);
                boolean notDuplicate = !revealed.contains(text);
                if (notInSafeZone && notDuplicate) important++;
                revealed.add(text);
            }
        }

        return important;
    }
}