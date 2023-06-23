import java.lang.reflect.Array;
import java.time.*;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException{
        List<String> list = new ArrayList<>();
        list.add("abc");
        if(list.contains("abc")) System.out.println("ok");
        else System.out.println("no");

        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("");
        stack.push("1");

//        stack.pop();
//        stack.peek();
        System.out.println(stack.search(""));
        System.out.println(stack.search("1"));
        System.out.println(stack.search("2"));
    }
}