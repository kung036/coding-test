import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        BigInteger ab = new BigInteger(a);
        BigInteger bb = new BigInteger(b);

        return ab.add(bb) + "";
    }
}