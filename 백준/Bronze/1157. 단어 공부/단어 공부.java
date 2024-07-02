// 5 시도 : 22:43.77
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toUpperCase();
        int[] chars = new int[26];

        for(char c : word.toCharArray()) {
            chars[c-65] = chars[c-65]+1;
        }

        int count = 0; // 가장 많이 사용된 알파벳 개수
        int index = 0; // 가장 많이 사용된 알파벳
        for(int i=1; i<chars.length; i++) {
            if(chars[index] == chars[i]) count++;
            else if(chars[index] < chars[i]) {
                count = 0;
                index = i;
            }
        }

        if(count > 0) System.out.println("?");
        else System.out.println((char)(index+65));
    }
}