package programmers;
import java.util.*;

public class Level2_뉴스_클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 65536;

        // 두 문자열을 전부 대문자로 만들기
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // 다중집합
        List<String> list1 = makeSet(str1); // str1의 다중집합
        List<String> list2 = makeSet(str2); // str2의 다중집합

        // 두 집합이 공집합인 경우(자카드 유사도 = 1)
        if(list1.size() == 0 && list2.size() == 0) return answer;

        // 합집합
        double s = list1.size() + list2.size();

        // 교집합
        List<String> sumList = new ArrayList<>();
        for(int i=0; i<list1.size(); i++) {
            if(list2.contains(list1.get(i))) {
                list2.remove(list1.get(i));
                sumList.add(list1.get(i));
            }
        }
        int c = sumList.size();
        s -= c;

        // 결과 계산
        answer = (int)(answer * c/s);

        return answer;
    }

    // 문자열의 다중집합 생성
    public List<String> makeSet(String str) {
        List<String> list = new ArrayList<>();
        for(int i=0; i<str.length()-1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);
            if(c1 < 65 || 90 < c1) continue; // 알파벳이 아닌 경우
            if(c2 < 65 || 90 < c2) continue; // 알파벳이 아닌 경우

            String element = String.valueOf(c1) + String.valueOf(c2);
            list.add(element);
        }
        return list;
    }
}