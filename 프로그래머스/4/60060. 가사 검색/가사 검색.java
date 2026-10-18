import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        List<String>[] fwd = new List[10001];
        List<String>[] rev = new List[10001];

        for (String w : words) {
            int len = w.length();
            if (fwd[len] == null) {
                fwd[len] = new ArrayList<>();
                rev[len] = new ArrayList<>();
            }
            fwd[len].add(w);
            rev[len].add(new StringBuilder(w).reverse().toString());
        }
        for (int i = 0; i <= 10000; i++) {
            if (fwd[i] != null) {
                Collections.sort(fwd[i]);
                Collections.sort(rev[i]);
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int len = q.length();
            if (fwd[len] == null) continue; // 길이 같은 단어 없음 → 0

            if (q.charAt(0) != '?') { // 접미사 ?
                answer[i] = count(fwd[len], q.replace('?', 'a'), q.replace('?', 'z'));
            } else {                  // 접두사 ? → 뒤집어서 처리
                String r = new StringBuilder(q).reverse().toString();
                answer[i] = count(rev[len], r.replace('?', 'a'), r.replace('?', 'z'));
            }
        }
        return answer;
    }

    private int count(List<String> list, String lo, String hi) {
        return upperBound(list, hi) - lowerBound(list, lo);
    }

    // target 이상인 첫 인덱스
    private int lowerBound(List<String> list, String target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (list.get(m).compareTo(target) >= 0) r = m;
            else l = m + 1;
        }
        return l;
    }

    // target 초과인 첫 인덱스
    private int upperBound(List<String> list, String target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (list.get(m).compareTo(target) > 0) r = m;
            else l = m + 1;
        }
        return l;
    }
}