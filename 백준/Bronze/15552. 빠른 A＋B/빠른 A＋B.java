// 4번 시도 : 32:03
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++) {
            int sum = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sum();
            wr.append(sum + "\n");
        }
        wr.flush();
    }
}