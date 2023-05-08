package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No21758 {
    public static int[] honeys;
    int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 벌통에 꿀 배치
        int count = Integer.parseInt(st.nextToken());
        honeys = new int[count];
        for(int i=0; i<count; i++) {
            honeys[i] = Integer.parseInt(st.nextToken());
        }

    }

    public static int findHoney() {

    }
}