import java.util.*;

class Solution {
    int[] parent = new int[2500];
    String[] val = new String[2500]; // 값은 루트 셀에만 저장

    int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    int idx(String r, String c) {
        return (Integer.parseInt(r) - 1) * 50 + Integer.parseInt(c) - 1;
    }

    public String[] solution(String[] commands) {
        for (int i = 0; i < 2500; i++) parent[i] = i;
        List<String> answer = new ArrayList<>();

        for (String cmd : commands) {
            String[] t = cmd.split(" ");
            switch (t[0]) {
                case "UPDATE":
                    if (t.length == 4) {
                        // UPDATE r c value
                        val[find(idx(t[1], t[2]))] = t[3];
                    } else {
                        // UPDATE value1 value2
                        for (int i = 0; i < 2500; i++) {
                            if (find(i) == i && t[1].equals(val[i])) val[i] = t[2];
                        }
                    }
                    break;

                case "MERGE": {
                    int a = find(idx(t[1], t[2]));
                    int b = find(idx(t[3], t[4]));
                    if (a == b) break;
                    // (r1,c1) 값 우선, 없으면 상대 값
                    String v = val[a] != null ? val[a] : val[b];
                    parent[b] = a;
                    val[a] = v;
                    val[b] = null;
                    break;
                }

                case "UNMERGE": {
                    int x = idx(t[1], t[2]);
                    int root = find(x);
                    String v = val[root];
                    List<Integer> group = new ArrayList<>();
                    for (int i = 0; i < 2500; i++) {
                        if (find(i) == root) group.add(i); // 초기화 전에 먼저 수집
                    }
                    for (int i : group) {
                        parent[i] = i;
                        val[i] = null;
                    }
                    val[x] = v;
                    break;
                }

                case "PRINT": {
                    String v = val[find(idx(t[1], t[2]))];
                    answer.add(v == null ? "EMPTY" : v);
                    break;
                }
            }
        }
        return answer.toArray(new String[0]);
    }
}