// 1번 시도 : 35분
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 행, 열
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        // 디자인
        String[][] result = new String[row*2][col*2];
        for(int i=0; i<row; i++) {
            result[i] = Arrays.copyOf(br.readLine().split(""), col*2);
        }

        // 디자인한 패턴
        for(int i=0; i<row; i++) {
            int index = col;
            for(int j=col-1; j>=0; j--) {
                result[i][index++] = result[i][j];
            }
        }
        int index = row;
        for(int i=row-1; i>=0; i--) {
            result[index++] = result[i].clone();
        }

        // 오타
        input = br.readLine().split(" ");
        int error_row = Integer.parseInt(input[0]) - 1;
        int error_col = Integer.parseInt(input[1]) - 1;
        if(result[error_row][error_col].equals("#")) result[error_row][error_col] = ".";
        else result[error_row][error_col] = "#";

        // 출력
        for(int i = 0; i < row * 2; i++) {
            for(int j = 0; j < col * 2; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}