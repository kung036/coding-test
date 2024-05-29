// 6번 시도 : 19:34
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        for(int i=0; i<row; i++) {
            double sum = 0;
            int count = sc.nextInt(); // 학생수
            int[] scores = new int[count]; // 점수

            // 평균 구하기
            for(int j=0; j<count; j++) {
                scores[j] = sc.nextInt();
                sum += scores[j];
            }

            // 평균 이상인 학생수 구하기
            double avg = sum / count; // 평균
            double overCount = 0; // 평균 이상인 학생수
            for(int j=0; j<count; j++) {
                if(scores[j] > avg) overCount++;
            }

            System.out.printf("%.3f%%\n", (overCount/count) * 100.0);
        }
    }
}