package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level2_무인도_여행 {

    public static void main(String[] args) {
        String[] maps1 = new String[]{
                "XXX", "XXX", "XXX"
        };
        int[] answer = Solution_무인도_여행.solution(maps1);
        System.out.println(Arrays.toString(answer));

        String[] maps2 = new String[] {
                "X591X","X1X5X","X231X", "1XXX1"
        };
        answer = Solution_무인도_여행.solution(maps2);
        System.out.println(Arrays.toString(answer));
    }
}

class Solution_무인도_여행 {
    public static int[] solution(String[] maps) {
        int[][] mapsInt = new int[maps.length][maps[0].length()];
        int[] answer = new int[]{};
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(maps[i].charAt(j) == 'X') mapsInt[i][j] = -1;
                else mapsInt[i][j] = Integer.valueOf(maps[i].charAt(j) + "");
//                System.out.print(mapsInt[i][j] + " ");
            }
//            System.out.println();
        }

        for(int i=0; i< mapsInt.length; i++) {
            for(int j=0; j< mapsInt[0].length; j++) {
                if(mapsInt[i][j] != -1) list.add(dfs(mapsInt, i, j));
            }
        }

        return list.isEmpty() ? new int[]{-1} : list.stream().mapToInt(value -> value).sorted().toArray();
    }

    public static int dfs(int[][] maps, int i, int j) {
        int sum = maps[i][j];

        if((i+1)<maps.length && maps[i+1][j] != -1) {
            sum += dfs(maps, i+1, j);
        }
        if((j+1)<maps[0].length && maps[i][j+1] != -1) {
            sum += dfs(maps, i, j+1);
        }
//        System.out.println("!! " + i + " " + j + " " + sum);

        maps[i][j] = -1;

        return sum;
    }
}
