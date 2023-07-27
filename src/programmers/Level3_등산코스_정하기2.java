package programmers;

import java.util.*;

// 등산코스 정하기
public class Level3_등산코스_정하기2 {
    public static void main(String[] args) {
        Node node = new Node(1, 2);
        Solution s = new Solution();
        s.solution("");
    }

    static class Node {
        int num;
        int weight;

        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    static class Solution {
        List<List<programmers.Node>> nums;
        public int solution(String numbers) {
            int answer = 0;

            // 그래프 그리기
            nums = new ArrayList<>();
            nums_init();

            // 다익스트라 알고리즘
            answer = dijkstra(numbers);


            return answer;
        }

        public int dijkstra(String num) {
            int[] numbers = Arrays.stream(num.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Queue<Integer> queue = new PriorityQueue<>();
//        queue.add();

            return numbers.length;
        }

        public void nums_init() {
            for(int i=0; i<10; i++) {
                nums.add(new ArrayList<>());
            }

            // 0
            nums.get(0).add(new programmers.Node(8, 2));
            nums.get(0).add(new programmers.Node(7, 3));
            nums.get(0).add(new programmers.Node(9, 3));
            // 1
            nums.get(1).add(new programmers.Node(2, 2));
            nums.get(1).add(new programmers.Node(4, 2));
            nums.get(1).add(new programmers.Node(5, 3));
            // 2
            nums.get(2).add(new programmers.Node(1, 2));
            nums.get(2).add(new programmers.Node(3, 2));
            nums.get(2).add(new programmers.Node(5, 2));
            nums.get(2).add(new programmers.Node(4, 3));
            nums.get(2).add(new programmers.Node(6, 3));
            // 3
            nums.get(3).add(new programmers.Node(2, 2));
            nums.get(3).add(new programmers.Node(6, 2));
            nums.get(3).add(new programmers.Node(5, 3));
            // 4
            nums.get(4).add(new programmers.Node(1, 2));
            nums.get(4).add(new programmers.Node(5, 2));
            nums.get(4).add(new programmers.Node(7, 2));
            nums.get(4).add(new programmers.Node(2, 3));
            nums.get(4).add(new programmers.Node(8, 3));
            // 5
            nums.get(5).add(new programmers.Node(2, 2));
            nums.get(5).add(new programmers.Node(4, 2));
            nums.get(5).add(new programmers.Node(6, 2));
            nums.get(5).add(new programmers.Node(8, 2));
            nums.get(5).add(new programmers.Node(1, 3));
            nums.get(5).add(new programmers.Node(3, 3));
            nums.get(5).add(new programmers.Node(7, 3));
            nums.get(5).add(new programmers.Node(9, 3));
            // 6
            nums.get(6).add(new programmers.Node(3, 2));
            nums.get(6).add(new programmers.Node(5, 2));
            nums.get(6).add(new programmers.Node(9, 2));
            nums.get(6).add(new programmers.Node(2, 3));
            nums.get(6).add(new programmers.Node(8, 3));
            // 7
            nums.get(7).add(new programmers.Node(4, 2));
            nums.get(7).add(new programmers.Node(8, 2));
            nums.get(7).add(new programmers.Node(5, 3));
            nums.get(7).add(new programmers.Node(0, 3));
            // 8
            nums.get(8).add(new programmers.Node(5, 2));
            nums.get(8).add(new programmers.Node(7, 2));
            nums.get(8).add(new programmers.Node(9, 2));
            nums.get(8).add(new programmers.Node(0, 2));
            nums.get(8).add(new programmers.Node(4, 3));
            nums.get(8).add(new programmers.Node(6, 3));
            // 9
            nums.get(9).add(new programmers.Node(6, 2));
            nums.get(9).add(new programmers.Node(8, 2));
            nums.get(9).add(new programmers.Node(5, 3));
            nums.get(9).add(new programmers.Node(0, 3));
        }
    }
}