package programmers;

public class Level2_예상_대진표 {
    public int solution(int n, int a, int b) {
        int answer = 1;
        int roundA = a%2 == 0 ? a/2 : (++a)/2;
        int roundB = b%2 == 0 ? b/2 : (++b)/2;

        while(roundA != roundB) {
            answer++;
            roundA = roundA%2 == 0 ? roundA/2 : (++roundA)/2;
            roundB = roundB%2 == 0 ? roundB/2 : (++roundB)/2;
            // System.out.println(roundA + " " + roundB);
        }

        return answer;
    }
}
