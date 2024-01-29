package programmers;
import java.util.*;

// 런타임 에러 & 효율성 테스트 통과 X
public class Level2_짝지어_제거하기 {
    public int solution(String s) {
        int answer = 0;

        int left = 0;
        int right = s.length() == 1 ? 0 : 1;

        List<String> arr = new ArrayList<>();
        Collections.addAll(arr, s.split(""));

        while(right != arr.size()-1 || arr.isEmpty()) {
            System.out.println("전 : " + arr.get(left) + " " + arr.get(right) + " " + left + " " + right);

            if(arr.get(left).equals(arr.get(right))) { // 앞뒤 같은 문자
                int tmpLeft = left;
                int tmpRight = right;

                if(left != 0) { // left는 첫번째가 아닌 경우
                    if(right == arr.size()-1) { // right는 마지막인 경우
                        left -= 2;
                        right -= 2;
                    } else { // 중간에 있는 경우
                        // left = 1 right = 2 -> baabaa
                        // left = 0 right = 1 -> bbaa
                        left -= 1;
                        right -= 1;
                    }
                }

                System.out.println("후 : " + tmpLeft + " " + tmpRight);
                // 동일한 문자 제거하기
                arr.remove(tmpLeft);
                arr.remove(tmpLeft);
            } else { // 앞뒤 문자가 다른 경우
                left++;
                right++;
            }
            System.out.println(arr);
        }

        if(arr.get(0).equals(arr.get(1))) answer = 1;

        return answer;
    }
}
