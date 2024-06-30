// 6번 시도 : 54분
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // DNA 개수
        int M = sc.nextInt(); // DNA 길이

        // DNA 입력
        char[][] DNAs = new char[N][M];
        for(int i=0; i<N; i++) {
            DNAs[i] = sc.next().toCharArray();
        }

        // 최소 Hamming Distance 구하기
        int hammingDistance = 0;
        String hamming = ""; // DNA 문자
        char[] DNA = new char[] {'A', 'C', 'G', 'T'};


        for(int j=0; j<M; j++) {
            int[] count = new int[4];
            for(int i=0; i<N; i++) {
                char cur = DNAs[i][j];
                if(cur == DNA[0]) count[0]++;
                else if(cur == DNA[1]) count[1]++;
                else if(cur == DNA[2]) count[2]++;
                else if(cur == DNA[3]) count[3]++;
            }

            // 같인 글자가 많은 문자 고르기
            int index = 0;
            for(int i=1; i<4; i++) {
                if(count[i] == 0) continue;
                if(count[index] == 0) index = i;
                else if(count[index] < count[i]) {
                    hammingDistance += count[index];
                    index = i;
                } else hammingDistance += count[i];
            }
            hamming += DNA[index];
        }

        System.out.println(hamming);
        System.out.println(hammingDistance);
    }
}