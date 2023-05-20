package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

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
        System.out.print("크레인 : ");
        Arrays.stream(crane_weigth).forEach(value -> System.out.print(value + " " ));
        System.out.print("\n박스 : ");
        Arrays.stream(box_weigth).forEach(value -> System.out.print(value + " " ));
        System.out.println("\nM : " + M);

        int startPoint = 0;
        int checkPoint = 0;
        while(true) {
            System.out.println("startPoint : " + startPoint + " checkPoint : " + checkPoint);
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
            System.out.println("startPoint : " + startPoint + " checkPoint : " + checkPoint);
            result++;
            System.out.println(result + "\n" + "-".repeat(20));
            if(checkPoint == -1 && startPoint >= M) break;
            if(checkPoint == -1) checkPoint = startPoint;
        }

        System.out.println(result);
    }
}
