// 4번 시도 : 21분
import java.util.*;
import java.io.*;

class Answers {
    int num;
    String answer;

    Answers(int num, String answer) {
        this.num = num;
        this.answer = answer;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String finish = "right on";
        List<Answers> answers = new ArrayList<>();
        int collectAnswer;

        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break;
            String answer = br.readLine();

            if(answer.equals(finish)) { // 정답인 경우
                collectAnswer = num;

                // stan 이 말하는 건 맞는데, 정답이 아닌 경우
                String result = "Stan may be honest";
                for(int i=0; i<answers.size(); i++) {
                    Answers curAnswer = answers.get(i);
                    if(curAnswer.answer.equals("too high") && collectAnswer < curAnswer.num) ;
                    else if(curAnswer.answer.equals("too low") && curAnswer.num < collectAnswer) ;
                    else {
                        result = "Stan is dishonest";
                        break;
                    }
                }
                System.out.println(result);
                answers.clear();
            }
            else answers.add(new Answers(num, answer));
        }
    }
}