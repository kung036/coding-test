package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Level2_4 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] plans = new String[][]{
                {"korean", "11:40", "30"},
                {"english", "12:10", "20"},
                {"math", "12:30", "40"}
        };

        String[] answer = s.solution(plans);
        System.out.print("answer : " ); // 7
        Arrays.stream(answer).forEach(s1 -> System.out.print(s1 + " "));
        System.out.println("\n");

        plans = new String[][]{
                {"science", "12:40", "50"},
                {"music", "12:20", "40"},
                {"history", "14:00", "30"},
                {"computer", "12:30", "100"}
        };
        answer = s.solution(plans);
        System.out.print("answer : "); // 7
        Arrays.stream(answer).forEach(s1 -> System.out.print(s1 + " "));
    }

    static class Solution {
        public String[] solution(String[][] plans) {
            List<String> answer = new ArrayList<>();
            Stack<Integer> s = new Stack<>();

            int[][] study = new int[plans.length][4];
            Arrays.sort(plans, (s1, s2) -> s1[1].compareTo(s2[1]));
            for(int i=0; i<plans.length; i++) {
                study[i][0] = Integer.valueOf(plans[i][1].substring(0, 2));
                study[i][1] = Integer.valueOf(plans[i][1].substring(3, 5));
                study[i][2] = Integer.valueOf(plans[i][2]);
                study[i][3] = i;
                System.out.print(plans[i][0] + " ");
            }
            Arrays.stream(study).forEach(strings ->{
                        Arrays.stream(strings).forEach(s1 -> System.out.print(s1 + " "));
                        System.out.println();
                    }
            );

            // 정렬하기
            for(int i=0; i<study.length; i++) {
                if(i != study.length-1) {
                    int time = (study[i+1][0] - study[i][0]) * 60 + study[i+1][1] - study[i][1];
                    if(time >= study[i][2]) {
                        answer.add(plans[study[i][3]][0]);

                        int leftTime = time - study[i][2];
                        while(leftTime > 0 && !s.isEmpty()) {
                            int[] tmp = study[s.peek()];
                            if(leftTime >= tmp[2]) answer.add(plans[study[s.pop()][3]][0]);
                            else tmp[2] -= leftTime;
                            leftTime -= tmp[2];
                        }
                    } else {
                        study[i][2] -= time;
                        s.push(i);
                    }
                } else {
                    answer.add(plans[i][0]);
                }
            }

            while(!s.isEmpty()) {
                answer.add(plans[study[s.pop()][3]][0]);
            }

            return answer.toArray(new String[answer.size()]);
        }
    }
}