package programmers;

import java.util.Arrays;

public class Level2_무인도_여행 {

    public static void main(String[] args) {

    }
}

class Solution_무인도_여행 {
    public int[] solution(String[] maps) {
        int[][] mapsInt = new int[maps.length][maps[0].length()];
        int[] answer = new int[]{};

        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(maps[i].charAt(j) == 'X') mapsInt[i][j] = -1;
                else mapsInt[i][j] = Integer.valueOf(maps[i].charAt(j));
            }
        }

        for(int i=0; i<mapsInt.length; i++) {
            for(int j=0; j<mapsInt[0].length-1; j++) {
                if(mapsInt[i][j] != -1) {
                    if(mapsInt[i][j+1] != -1) {
                        mapsInt[i][j+1] += mapsInt[i][j];
                        mapsInt[i][j] = 0;
                    }
                    if((i+1)<mapsInt.length && mapsInt[i+1][j] != -1) {

                    }
                }
            }
        }


        return answer;
    }
}
