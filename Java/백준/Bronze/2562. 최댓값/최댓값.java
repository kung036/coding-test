import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int index = 0;

        for(int i=0; i<9; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] > arr[index]) index = i;
        }
        
        System.out.println(arr[index]);
        System.out.println(index+1);
    }
}