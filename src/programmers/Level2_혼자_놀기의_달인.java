package programmers;

// 혼자 놀기의 달인
public class Level2_혼자_놀기의_달인 {
    public int solution(int[] cards) {
        int answer = 0;

        for(int i=0; i<cards.length; i++) {
            int result = find(cards.clone(), i);

            // 1번 상자 그룹 이외 남는 상자가 없는 경우
            if(result == 0) return answer;
            if(answer < result) answer = result;
        }

        return answer;
    }

    public int find(int[] cards, int index) {
        int box1 = 1;
        int box2 = 0;
        int cur = cards[index];
        cards[index] = -1;

        while(true) {
            int tmp = cards[cur-1];
            if(tmp != -1) {
                box1++;
                cards[cur-1] = -1;
                cur = tmp;
            } else break;
        }

        if(box1 == cards.length) return 0;

        for(int i=0; i<cards.length; i++) {
            if(cards[i] != -1) {
                int[] tmp_cards = cards.clone();
                cur = tmp_cards[i];
                int tmp_box2 = 0;
                while(true) {
                    int tmp = tmp_cards[cur-1];
                    if(tmp != -1) {
                        tmp_box2++;
                        tmp_cards[cur-1] = -1;
                        cur = tmp;
                    } else break;
                }
                if(tmp_box2 > box2) box2 = tmp_box2;
            }
        }

        return box1 * box2;
    }
}