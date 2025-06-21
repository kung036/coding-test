import java.util.ArrayList;

class Solution {
    public String[] solution(String myStr) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < myStr.length(); i++) {
            char c = myStr.charAt(i);
            if (c == 'a' || c == 'b' || c == 'c') {
                if (sb.length() > 0) {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }
        // 마지막에 남은 문자열 추가
        if (sb.length() > 0) {
            list.add(sb.toString());
        }
        
        if (list.isEmpty()) {
            return new String[]{"EMPTY"};
        } else {
            return list.toArray(new String[0]);
        }
    }
}
