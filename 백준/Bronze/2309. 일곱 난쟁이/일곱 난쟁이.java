// 4번 시도 : 17분
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 키
        int[] heights = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++) {
            heights[i] = Integer.parseInt(br.readLine());            
            sum += heights[i];
        }
        heights = Arrays.stream(heights).sorted().toArray();
        
        // 다른 난쟁이 구하기
        int find = sum - 100;        
        for(int i=0; i<8; i++) {
            int nonSum = heights[i];
            for(int j=i+1; j<9; j++) {
                nonSum += heights[j];
                if(nonSum == find) {
                    heights[i] = -1;
                    heights[j] = -1;
                    break;
                }
                nonSum -= heights[j];
            }
            if(nonSum == find) break;
        }
        
        // 출력
        for(int i=0; i<9; i++) {
            if(heights[i] != -1) System.out.println(heights[i]);
        }
    }
}