//package backjoon;
//
//import java.io.*;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class No1092 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine()); // 크레인 개수
//        List<Integer> crane_weigth =
//                Arrays.stream(br.readLine().split(" "))
//                        .map(s -> Integer.parseInt(s))
//                        .sorted(Comparator.reverseOrder())
//                        .collect(Collectors.toList());  // 크레인별 무게 제한
//        int M = Integer.parseInt(br.readLine()); // 박스 개수
//        List<Integer> box_weigth =
//                Arrays.stream(br.readLine().split(" "))
//                        .map(s -> Integer.parseInt(s))
//                        .sorted(Comparator.reverseOrder())
//                        .collect(Collectors.toList()); // 크레인별 무게 제한
//
//        Collections.sort(crane_weigth, Collections.reverseOrder());
//        Collections.sort(box_weigth, Collections.reverseOrder());
//
//        // edge
//        if(crane_weigth.get(0) < box_weigth.get(0)) {
//            System.out.println(-1);
//            return;
//        }
//
//        int result = 0; // 결과
////        System.out.print("크레인 : ");
////        Arrays.stream(crane_weigth).forEach(value -> System.out.print(value + " " ));
////        System.out.print("\n박스 : ");
////        Arrays.stream(box_weigth).forEach(value -> System.out.print(value + " " ));
////        System.out.println("\nM : " + M);
//
//        while(!box_weigth.isEmpty()) {
//            int idx = 0;
//            for(int i=0; i<N;) {
//                if(idx == box_weigth.size()) break;
//                if(box_weigth.get(idx) <= crane_weigth.get(i)) {
//                    box_weigth.remove(idx);
//                    i++;
//                } else idx++;
//            }
//            result++;
//        }
//
//        System.out.println(result);
//    }
//}

// 내가 작성한 코드
package backjoon;

import java.io.*;
import java.util.*;

public class No1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 크레인 개수
        int[] crane_weigth =
                Arrays.stream(br.readLine().split(" "))
                        .map(s -> Integer.parseInt(s))
                        .sorted(Comparator.reverseOrder())
                        .mapToInt(value -> value)
                        .toArray();  // 크레인별 무게 제한
        int min = crane_weigth[N-1]; // 크레인의 최소 무게 제한
        int M = Integer.parseInt(br.readLine()); // 박스 개수
        int[] box_weigth =
                Arrays.stream(br.readLine().split(" "))
                        .map(s -> Integer.parseInt(s))
                        .sorted(Comparator.reverseOrder())
                        .mapToInt(value -> value)
                        .toArray();  // 크레인별 무게 제한

        int result = 0; // 결과
        boolean[] visited = new boolean[M];

        // edge
        if(crane_weigth[0] < box_weigth[0]) {
            System.out.println(-1);
            return;
        }


        int startPoint = 0;
        int checkPoint = 0;
        while(true) {
            startPoint = checkPoint;
            checkPoint = -1;
            for(int i=0; i<N; i++) {
                if(visited[startPoint])
                    while(visited[startPoint]) {
                        startPoint++;
                        if(startPoint >= M) break;
                    }
                if(startPoint >= M) break;

                if(!visited[startPoint]){
                    if(box_weigth[startPoint] <= crane_weigth[i]) {
                        visited[startPoint] = true;
                        startPoint++;
                    } else {
                        if(checkPoint == -1) checkPoint = startPoint;
                        for(int j=startPoint; j<M; j++) {
                            if(box_weigth[j] <= crane_weigth[i] && !visited[j]) {
                                visited[j] = true;
                                startPoint = j+1;
                                break;
                            }
                        }
                    }
                }
                if(startPoint >= M) break;
            }
            result++;
            if(checkPoint == -1 && startPoint >= M) break;
            if(checkPoint == -1) checkPoint = startPoint;
        }

        System.out.println(result);
    }
}