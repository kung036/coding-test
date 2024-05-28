import java.util.*;

public class Main {
    public static void main(String[] argc) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        
        char scoreChar;
        if(score >= 90) scoreChar = 'A';
        else if(score >= 80) scoreChar = 'B';
        else if(score >= 70) scoreChar = 'C';
        else if(score >= 60) scoreChar = 'D';
        else scoreChar = 'F';
        
        System.out.println(scoreChar);
    }
}