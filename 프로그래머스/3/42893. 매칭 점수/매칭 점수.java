import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String word, String[] pages) {
        int n = pages.length;
        word = word.toLowerCase();

        Pattern urlPattern = Pattern.compile("<meta property=\"og:url\" content=\"(https://[^\"]+)\"");
        Pattern linkPattern = Pattern.compile("<a href=\"(https://[^\"]+)\"");

        Map<String, Integer> idxByUrl = new HashMap<>();
        double[] basic = new double[n];
        int[] outCount = new int[n];
        List<List<String>> outLinks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String page = pages[i];

            // 1) 자기 url
            Matcher um = urlPattern.matcher(page);
            if (um.find()) idxByUrl.put(um.group(1), i);

            // 2) body만 사용
            int bodyStart = page.indexOf("<body");
            String body = bodyStart >= 0 ? page.substring(bodyStart) : page;

            // 3) 외부 링크 수집
            List<String> links = new ArrayList<>();
            Matcher lm = linkPattern.matcher(body);
            while (lm.find()) links.add(lm.group(1));
            outLinks.add(links);
            outCount[i] = links.size();

            // 4) 기본점수: 태그를 지우고, 알파벳이 아닌 문자로 쪼개 단어 단위로 비교
            String text = body.replaceAll("<[^>]*>", " ").toLowerCase();
            int cnt = 0;
            for (String token : text.split("[^a-z]+")) {
                if (token.equals(word)) cnt++;
            }
            basic[i] = cnt;
        }

        // 5) 링크점수 = 나에게 링크를 건 페이지들의 (기본점수 / 외부 링크 수) 합
        double[] score = basic.clone();
        for (int i = 0; i < n; i++) {
            if (outCount[i] == 0) continue;
            double give = basic[i] / outCount[i];
            for (String url : outLinks.get(i)) {
                Integer target = idxByUrl.get(url);
                if (target != null) score[target] += give;
            }
        }

        // 6) 최대 매칭점수, 동점이면 index가 작은 쪽
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (score[i] > score[answer]) answer = i;
        }
        return answer;
    }
}