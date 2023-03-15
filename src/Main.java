public class Main {
    public static void main(String[] args) {
        String str1 = "AFCB";
        String str2 = "BAFC";
        String str3 = "BAFCZ";
        String str4 = "AFD";
        String str  = "AFC";

        System.out.println(str1.compareTo(str));
        System.out.println(str2.compareTo(str));
        System.out.println(str3.compareTo(str));
        System.out.println(str4.compareTo(str));
        System.out.println(str3.replace(str, ""));

        System.out.println("AAFCA".matches("[A-F]AFC[A-F]"));

    }
}