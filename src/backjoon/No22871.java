package backjoon;

import java.util.*;
import java.io.*;

// 징검다리 건너기(large)
public class No22871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 돌의 개수
        int answer = -1; // K의 최솟값
        int[][] power = new int[5000][5001]; // 돌끼리 이동하는 힘

        // 돌에게 주어진 수 입력받기
        for(int i=1; i<=n; i++) {
            power[i][0] = sc.nextInt();
        }

        // 돌끼리 이동하는 힘 구하기
        for(int i=1; i<n; i++) {
            for(int j=i+1; j<=n; j++) {
                power[i][j] = (j-i) * (1 + Math.abs(power[i][0] - power[j][0]));
            }
        }

        // 모든 경우의 수를 계산해서 K의 최솟값 구하기
        Stack<int[]> stack = new Stack<>();
        List<int[]> list = new ArrayList<>(); // 이동한 순서

        for(int i=2; i<=n ;i++) {
            int[] tmp = new int[]{1, i};
            int k = power[1][i]; // 각 경우의 k 값
            stack.add(tmp);
            list.add(tmp);

            while(true) {
//                System.out.println(tmp[0] + " " + tmp[1]);
                if(tmp[1] != n) { // 돌을 건널 때까지 건너는 경우 추가
                    tmp = new int[]{tmp[1], tmp[1]+1};
                    stack.add(tmp);
                    list.add(tmp);
//                    System.out.print("추가 - " );
//                    findK(list, power);
                } else { // 돌을 전부 건너는 경우
                    k = findK(list, power); // k값 구하기
//                    System.out.println("k값 : " + k);
                    if(answer == -1 || k < answer) answer = k;

                    tmp = stack.pop();
                    list.remove(list.size()-1);
                    if(!stack.isEmpty()) {
                        tmp = stack.pop();
                        list.remove(list.size()-1);

                        tmp = new int[] {tmp[0], tmp[1]+1};
                        stack.add(tmp);
                        list.add(tmp);
//                        System.out.print("빼기 - ");
//                        findK(list, power);
                    } else break;
                }
            }
        }

        System.out.println(answer); // K의 최솟값 출력
    }

    // 가장 작은 K의 값 찾기
    public static int findK(List<int[]> list, int[][] power) {
//        System.out.print("list = [");
//        list.stream().forEach(ints -> System.out.print("[" + ints[0] + ", " + ints[1] + "], "));
//        System.out.println("\b\b]");
//        System.out.print("K값 : ");
//        list.stream().forEach(value -> System.out.print(power[value[0]][value[1]] + " "));
//        System.out.println();
        return list.stream()
                .mapToInt(value -> power[value[0]][value[1]])
                .max()
                .getAsInt();
    }
}
